/**
 * @file inititator.js
 * @author betgar (betgar@163.com)
 * @date 09/03/2018
 * @time 15:00:23
 * @description
 */
(function (global, $) {
  "use strict";
  // 如果在requirejs之前引入jquery,做一个适配.
  if (typeof $ === "function" && $().jquery) {
    define('jquery', [], function () {
      return $;
    });
  }
  var consoleLog = (window.console && window.console.log
    && typeof (window.console.log) === 'function') ? window.console.log : function () { };
  require(['jquery'], function ($) {
    var initiator = {
      el: null, // $(script'[src^="initiator.js]')
      srcAttr: 'initiator.js',
      _baseUrl: null,
      _scriptNodes: document.getElementsByTagName('script'),
      /**
       * @return {string} - 返回baseUrl.
       */
      findBaseUrl: function () {
        if (this.el && !this._baseUrl) {
          this._baseUrl = (this.el.dataset ? this.el.dataset.baseUrl : this.el.getAttribute('data-base-url')) || '';
          return this._baseUrl;
        } else {
          return '';
        }
      },
      _findTarget: function (nodes) {
        var eles = nodes || [], target, value;
        for (var index = 0; index < eles.length; index++) {
          value = eles[index].getAttribute('src');
          if (value && value.indexOf(this.srcAttr) !== -1) {
            target = eles[index];
            break;
          }
        }
        return target;
      },
      /**
       * 初始化.
       */
      init: function () {
        this.el = this._findTarget(this._scriptNodes);
      }
    };
    initiator.init(); // 初始化

    var fetchRequireConfig = function (configId, customConfigId, customGlobalOptions) {
      var presettingEvent = {
        hasDoc: !!global.document,
        events: {
          beforeSetConfig: 'beforeSetConfig.initiator',
          afterSetConfig: 'afterSetConfig.initiator',
          beforeLoadEntry: 'beforeLoadEntry.initiator',
          afterLoadEntry: 'afterLoadEntry.initiator'
        },
        trigger: function (eventName, data) {
          if (this.hasDoc) {
            data ? $(global.document).trigger(eventName, data) : $(global.document).trigger(eventName);
          }
        }
      };
      return $.Deferred(function (dfd) {
        // 加载配置
        require([configId].concat(customConfigId), function (config) {
          var customOptions = $.makeArray(arguments).slice(1);
          // initiator.js script标签的data-*合并到global-config.js
          var mergedOptions = $.extend(true, {}, config.originGlobalConfig(), customGlobalOptions);
          // merge globalConifg + customConfig to config .
          config.store({
            globalConfig: mergedOptions
          });
          dfd.resolve(config);
          var presettingOptions = config.fetch(mergedOptions);
          // initiator.js script标签的data-coustom-config属性值配置文件返回的object和
          // 默认配置的defaultOptions合并.
          var options = $.extend(true, {}, presettingOptions);
          $.each(customOptions, function (index, config) {
            $.extend(options, config);
          });

          presettingEvent.trigger(presettingEvent.events.beforeSetConfig);
          // reset require config
          require.config(options);
          presettingEvent.trigger(presettingEvent.events.afterSetConfig);

          // start load entry
          presettingEvent.trigger(presettingEvent.events.beforeLoadEntry);
          if ($.trim(customGlobalOptions.customEntry)) {
            require([customGlobalOptions.customEntry], function () {
              presettingEvent.trigger(presettingEvent.events.afterLoadEntry);
            });
          }
        }, function (err) {
          dfd.reject(err);
        });
      }).promise();
    };

    /**
     * 定义的基础的require config配置(baseUrl, config文件地址)
     * defaultRequireConfig.call()作用 <br>
     * 1.合并initiator.data() 和 config地址组成多个depConfigs <br>
     * 2.合并initiator.data() 和 config.originGlobalConfig()中配置行程新的globalConfig <br>
     * 3.加载配置的文件入口.  <br>
     */
    var defaultRequireConfig = {
      baseUrl: initiator.findBaseUrl() || 'js',
      packages: [
        {
          name: 'dodo',
          main: 'dodo'
        },
        {
          name: 'config',
          main: 'config'
        }
      ],
      deps: [
        'config'
      ],
      callback: function () {
        var customGlobalOptions = $(initiator.el).data() || {};
        var customConfigUrl = customGlobalOptions.envMode === 'dev' ? (customGlobalOptions.customDevConfig || customGlobalOptions.customConfig) : customGlobalOptions.customConfig;
        // customDeps不能依赖其它组件，因为加载时config还没有设置.
        fetchRequireConfig('config', customConfigUrl || [], customGlobalOptions)
          .done(function (config) {
            var mergedOptions = config.store().globalConfig;
            if (mergedOptions.envMode === 'dev') {
              consoleLog(mergedOptions);
            }
          }).fail(function () { });
      }
    };

    require.config(defaultRequireConfig);
    // default requirejs error handler
    requirejs.onError = function (err) {
      // err.requireType: scripterror, timeout, nodefine
      window.console && window.console.error && window.console.error(err.requireType + ': moduleName --> ' + err.requireModules);
      throw err;
    };
  });
}(typeof window !== "undefined" ? window : this, jQuery));


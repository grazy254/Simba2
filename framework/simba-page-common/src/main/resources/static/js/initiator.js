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
      paths: {
        text: './requirejs/plugins/text/2.0.15/js/text',
        i18n: './requirejs/plugins/i18n/2.0.6/i18n',
        domReady: './requirejs/plugins/domready/2.0.1/js/domReady',
        css: './requirejs/plugins/css/0.1.10/js/css'
      },
      deps: [
        'config'
      ],
      callback: function () {
        var presetEvent = {
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
        var customGlobalOptions = $(initiator.el).data() || {};
        var customConfigUrl = customGlobalOptions.envMode === 'dev' ? (customGlobalOptions.customDevConfig || customGlobalOptions.customConfig) : customGlobalOptions.customConfig;
        // customDeps不能依赖其它组件，因为加载时config还没有设置.
        var deps = ['config'].concat(customConfigUrl || []);

        // 加载配置
        require(deps, function (config) {
          var customOptions = $.makeArray(arguments).slice(1);
          // initiator.js script标签的data-*合并到global-config.js
          var mergedOptions = $.extend({}, config.originGlobalConfig(), customGlobalOptions, true);
          var presettingOptions = config.fetch(mergedOptions);
          // initiator.js script标签的data-coustom-config属性值配置文件返回的object和
          // 默认配置的defaultOptions合并.
          var options = $.extend({}, presettingOptions);
          $.each(customOptions, function (index, config) {
            $.extend(options, config);
          });
          presetEvent.trigger(presetEvent.events.beforeSetConfig);
          require.config(options); // reset require config
          presetEvent.trigger(presetEvent.events.afterSetConfig);


          presetEvent.trigger(presetEvent.events.beforeLoadEntry);
          if ($.trim(customGlobalOptions.customEntry)) {
            require([customGlobalOptions.customEntry], function () {
              presetEvent.trigger(presetEvent.events.afterLoadEntry);
            });
          }

        });
      }
    };

    require.config(defaultRequireConfig);
  });
}(typeof window !== "undefined" ? window : this, jQuery));


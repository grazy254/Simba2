/**
 * @file config.js
 * @author betgar (betgar@163.com)
 * @date 09/03/2018
 * @time 15:18:41
 * @description
 */
define([
  'dodo',
  './global-config',
  './require-config/require-config'
], function (dodo, globalConfig, requireConfig) {
  'use strict';
  var configs = {
    globalConfig: dodo.extend(true, {}, globalConfig)
  };
  return {
    /**
     * @return {Object} - 全局配置对象。
     */
    originGlobalConfig: function () {
      return dodo.extend(true, {}, globalConfig);
    },
    /**
     * 获得配置.
     * @param {Object} [config] - 配置.
     * @return {Object | undefined} - 储存的对象。
     */
    store: function (config) {
        if (arguments.length === 1) {
          dodo.extend(configs, config);
        } else {
          return configs;
        }
    },
    /**
     * @param {Object} options - globalConfig对象
     * @return {Object} - require config对象
     */
    fetch: function (options) {
      return requireConfig.fetchBy(options);
    }
  };
});

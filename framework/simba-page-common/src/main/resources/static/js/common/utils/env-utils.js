/**
 * @file env-utils.js
 * @author betgar (betgar@163.com)
 * @date 09/20/2018
 * @time 17:22:50
 * @description 判断运行环境工具类.
 */

define([
  'jquery',
  'config'
], function ($, config) {
  'use strict';
  var store = config.store(),
    globalConfig = store.globalConfig;

  var envUtil = {
    isDebug: function () {
      return globalConfig.envMode === 'dev';
    },
    isDev: function () {
      return this.isDebug();
    },
    isProd: function () {
      return globalConfig.envMode === 'prod';
    }
  };
  return envUtil;
});

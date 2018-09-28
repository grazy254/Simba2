/**
 * @file require-config.js
 * @author betgar (betgar@163.com)
 * @date 08/29/2018
 * @time 15:41:19
 * @description
 */
define(function (require) {
  "use strict";
  return {
    fetchBy: function (globalConfig) {
      var envMode = globalConfig.envMode, options; // dev or prod
      switch (envMode) {
        case 'dev':
          options = require('./dev-config');
          break;
        case 'prod':
          options = require('./prod-config');
          break;
        default:
          options = require('./prod-config');
          break;
      }
      return options;
    }
  };
});
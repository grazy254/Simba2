/**
 * @file helper.js
 * @author betgar (betgar@163.com)
 * @date 09/20/2018
 * @time 09:04:51
 * @description
 */

define([
  'jquery',
  'dodo',
  './base-helper',
  './helper-config'
], function ($, dodo, BaseHelper, helperConfig) {
  'use strict';
  // var $ = require('jquery'),
  //   dodo = require('dodo'),
  //   BaseHelper = require('./base-helper'),
  //   helperConfig = require('./helper-config');
  /**
   * @typedef {Object} PluginFactoryOptions
   * @property {string} type - plugin的类型
   */

  /**
   * @param  {PluginFactoryOptions} options - 函数.
   * @return {BaseHelper}
   */
  function PluginFactory(options) {
    return $.Deferred(function (dfd) {
      if (dodo.isObject(options) && dodo.isEmptyTrimmedString(options.type)) {
        throw new Error({
          name: 'arguments type not match',
          message: 'Invalid arguments type of PluginFactory.'
        });
      }
      if (!helperConfig.config(options.type)) {
        throw new Error({
          name: 'helper not found',
          message: 'Not found ' + options.type + ' in the helper config.'
        });
      }

      require([helperConfig.config(options.type)], function (metadataOptions) {
        dfd.resolve(new BaseHelper(metadataOptions));
      });
    });
  }

  return {
    factory: PluginFactory
  };
});

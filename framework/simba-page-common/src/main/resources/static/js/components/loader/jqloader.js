/**
 * @file jqloader.js
 * @author betgar (betgar@163.com)
 * @date 09/10/2018
 * @time 09:13:25
 * @description
 */
define([
  'jquery',
  'jquery-loading-indicator'
], function($) {
  'use strict';
  var pluginName = 'loadingIndicator';
  return {
    show: function (el, options) {
      var $el = $(el), instance = $(el).data(pluginName);
      if (instance) {
        instance.show();
      } else {
        $el[pluginName](options);
      }
     },
     hide: function (el) {
      var instance = $(el).data(pluginName);
      if (instance) {
        instance.hide();
      }
    }
  };
});

/**
 * @file jq-loader.js
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
    /**
     *  @param  {string | jQuery | HTMLElement} el
     * @param  {Object} [options]
     */
    show: function (el, options) {
      var $el = $(el), instance = $(el).data(pluginName);
      if (instance) {
        return instance.show();
      } else {
        return $el[pluginName](options);
      }
     },
     /**
      * @param  {string | jQuery | HTMLElement} el
      */
     hide: function (el) {
      var instance = $(el).data(pluginName);
      if (instance) {
        return instance.hide();
      }
    }
  };
});

/**
 * @file bs-datetimepicker-config.js
 * @author betgar (betgar@163.com)
 * @date 09/28/2018
 * @time 15:33:40
 * @description bootstrap datetimepicker default config.
 */
define([
  'jquery',
  'bs-datetimepicker'
], function($) {
  'use strict';
  var defaultOptions = function () {
    return {
      locale: 'zh-cn',
      format: 'YYYY-MM-DD HH:mm'
    };
  };

  return {
    ctor: $.fn.datetimepicker,
    defaults: $.fn.datetimepicker.defaults,
    defaultOptions: defaultOptions()
  };
});

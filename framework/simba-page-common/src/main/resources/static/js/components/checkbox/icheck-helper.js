define([
  'jquery',
  'icheck'
], function ($) {
  'use strict';
  var defaultOptions = function () {
    return {
      checkboxClass: 'icheckbox_flat-blue',
      radioClass: 'iradio_flat-blue'
    };
  };

  var helper = {
    options: function (option) {
      if (arguments.length === 1) {
        $.extend($.fn.icheck.defaults, option || {});
      } else {
        return $.extend({}, $.fn.icheck.defaults);
      }
    },
    render: function (el, options) {
      return $(el).iCheck($.extend({}, defaultOptions(), options || {}));
    }
  };

  $.each([
    'check', 'uncheck', 'enable',
    'disable', 'update', 'destroy',
    'indeterminate', 'determinate'
  ], function (index, method) {
    helper[method] = function (el) {
      return $(el).iCheck(method);
    }
  });
  return helper;
});

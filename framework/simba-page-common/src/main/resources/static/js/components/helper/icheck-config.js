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

  return {
    ctor: $.fn.iCheck,
    defaults: $.fn.iCheck.defaults,
    defaultOptions: defaultOptions()
  };
});

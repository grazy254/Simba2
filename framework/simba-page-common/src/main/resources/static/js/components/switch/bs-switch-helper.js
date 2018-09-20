define([
  'jquery',
  'bs-switch'
], function ($) {
  'use strict';
  var defaultOptions = function () {
    return {
      size: 'small'
    };
  };

  /**
   * @typedef {Object} BsSwitchOptions
   * @property {boolean} [state = true]
   * @property {string} [size = null]
   * @property {boolean} [animate = true]
   * @property {boolean} [disabled = false]
   * @property {boolean} [readonly = false]
   * @property {boolean} [indeterminate = false]
   * @property {boolean} [inverse = false]
   * @property {boolean} [radioAllOff = false]
   * @property {string} [onColor = 'primary']
   * @property {string} [offColor = 'default']
   * @property {string} [onText = 'ON']
   * @property {string} [offText = 'OFF']
   * @property {string} [labelText = '&nbsp']
   * @property {string} [labelWidth = 'auto']
   * @property {string} [handleWidth = 'default']
   * @property {string} [baseClass = 'bootstrap-switch']
   * @property {string} [wrapperClass = 'wrapper']
   * @property {Function} [wrapperClass = null]
   * @property {Function} [onSwitchChange = null]
   */
  var originDefault = $.fn.bootstrapSwitch.defaults;
  return {
    options: function (option) {
      $.extend(originDefault, option || {}, true);
    },
    /**
     * @param {HTMLElement | String | jQuery} el - 元素
     * @param {BsSwitchOptions} [options] - 配置项
     */
    render: function (el, options) {
      var opts = $.extend({}, defaultOptions(), options || {});
      return $(el).bootstrapSwitch(opts);
    },
    val: function (el) {
      return $(el).bootstrapSwitch('state');
    }
  };
});

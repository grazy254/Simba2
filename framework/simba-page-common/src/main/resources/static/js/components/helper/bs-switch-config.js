define([
  'jquery',
  'bs-switch'
], function ($, BaseHelper) {
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
  return {
    ctor: $.fn.bootstrapSwitch,
    defaults: $.fn.bootstrapSwitch.defaults,
    defaultOptions: defaultOptions()
  };
});

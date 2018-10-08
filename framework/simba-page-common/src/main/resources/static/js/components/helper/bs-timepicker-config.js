define([
  'jquery',
  'bs-timepicker'
], function ($, BaseHelper) {
  'use strict';
  /**
   * @typedef { Object } iCheckOptions
   * @property {String}  [defaultTime = current]
   * @property {Boolean}  [disableFocus = false]
   * @property {Boolean}  [disableMousewheel = false]
   * @property {Boolean}  [isOpen = false]
   * @property {Number}  [minuteStep = 15]
   * @property {Boolean}  [modalBackdrop = false]
   * @property {Object}  [orientation]
   * @property {String}  [orientation.x = auto]
   * @property {String}  [orientation.y = auto]
   * @property {Number}  [secondStep = 15]
   * @property {Boolean}  [snapToStep = false]
   * @property {Boolean}  [showSeconds = false]
   * @property {Boolean}  [showInputs = true]
   * @property {Boolean}  [showMeridian = true]
   * @property {String}  [template = dropdown]
   * @property {String}  [appendWidgetTo = body]
   * @property {Boolean}  [showWidgetOnAddonClick = true]
   * @property {Object}  [icons]
   * @property {String}  [icons.up = glyphicon glyphicon-chevron-up]
   * @property {String}  [icons.down = glyphicon glyphicon-chevron-down]
   * @property {Number}  [maxHours = 24]
   * @property {Boolean}  [explicitMode = false]
   */

  var defaultOptions = function () {
    return {
      showMeridian: false, // hide AM and PM
      showInputs: false // hide input
    };
  };

  return {
    ctor: $.fn.timepicker,
    defaults: $.fn.timepicker.defaults,
    defaultOptions: defaultOptions()
  };
});

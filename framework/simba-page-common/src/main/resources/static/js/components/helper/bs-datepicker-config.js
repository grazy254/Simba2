define([
  'jquery',
  'bs-datepicker-zh'
], function ($) {
  'use strict';
  var defaultOptions = function () {
    return {
      format: 'yyyy-mm-dd',
      language: 'zh-CN',
      autoclose: true
    };
  };

  /**
   * @typedef {Object} BsDatePickerOptions
   * @property {boolean} [autoclose = false]
   * @property {boolean} [assumeNearbyYear = false]
   * @property {Function} [beforeShowDay = null]
   * @property {Function} [beforeShowMonth = null]
   * @property {Function} [beforeShowYear = null]
   * @property {Function} [beforeShowDecade = null]
   * @property {Function} [beforeShowCentury = null]
   * @property {boolean} [calendarWeeks = false]
   * @property {boolean} [clearBtn = false]
   * @property {string} [container = 'body']
   * @property {Number[]} [datesDisabled = []]
   * @property {Number[]} [daysOfWeekDisabled = []]
   * @property {Number[]} [daysOfWeekHighlighted = []]
   * @property {string} [defaultViewDate = 'today']
   * @property {boolean} [disableTouchKeyboard = false]
   * @property {boolean} [enableOnReadonly = true]
   * @property {number} [endDate = Infinity]
   * @property {boolean} [forceParse = true]
   * @property {string} [format = 'mm/dd/yyyy']
   * @property {boolean} [inputs]
   * @property {boolean} [keepEmptyValues = false]
   * @property {boolean} [keyboardNavigation = true]
   * @property {string} [language = 'en']
   * @property {string} [maxViewMode ]
   * @property {string} [minViewMode ]
   * @property {boolean} [multidate = false]
   * @property {string} [multidateSeparator = ',' ]
   * @property {string} [orientation ]
   * @property {string} [showOnFocus = true ]
   * @property {Number} [startDate = 	-Infinity ]
   * @property {Number} [startView = 	0 ]
   * @property {string} [templates  ]
   * @property {string} [title = 	'' ]
   * @property {boolean} [todayBtn = false ]
   * @property {boolean} [todayHighlight = true]
   * @property {boolean} [toggleActive = 	false]
   * @property {Number} [weekStart = 	0 ]
   * @property {Number} [zIndexOffset = 10 ]
   */

  $.fn.datepicker.dates["zh-CN"].format = 'yyyy-mm-dd';

  return {
    ctor: $.fn.datepicker,
    defaults: $.fn.datepicker.defaults,
    defaultOptions: defaultOptions()
  };
});

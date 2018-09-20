define([
  "dodo",
  "./base-config"
],
function (dodo, baseConfig) {
  "use strict";
  return dodo.extend({}, baseConfig, {
    "paths": {
      "bootstrap3": "./plugins/bootstrap3/3.3.7/js/bootstrap",
      "adminlte": "./plugins/adminlte/2.4.2/js/adminlte",
      "backbone": "./plugins/backbone/1.3.3/js/backbone",
      "underscore": "./plugins/underscore/1.9.1/js/underscore",

      "layer": "./plugins/layer/3.1.1/layer",
      "slimscroll": "./plugins/jquery-slimscroll/1.3.8/jquery.slimscroll",
      "fastclick": "./plugins/fastclick/1.3.8/fastclick",
      "jquery-loading-indicator": "./plugins/jquery-loading-indicator/3.3.1/js/jquery.loading-indicator",
      // *** form plugins ***
      // AMD module plugins
      "bs-datetimepicker": "./plugins/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker",
      "bs-datepicker": "./plugins/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker",
      "bs-switch": "./plugins/bootstrap-switch/3.3.4/js/bootstrap-switch",
      // not AMD module plugins
      "bs-datepicker-zh": "./plugins/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min",
      "icheck": "./plugins/icheck/1.0.2/js/icheck",
      "bs-timepicker": "./plugins/bootstrap-timepicker/0.5.2/js/bootstrap-timepicker",

      // *** date libraries plugins ***
      "moment": "./plugins/moment/2.22.2/js/moment-with-locales"
    },
    "shim": {
      "bootstrap3": {
        "deps": [
          "jquery"
          // manual add css files to document
        ]
      },
      "adminlte": {
        "deps": [
          "jquery",
          "css!./plugins/ionicons/2.0.0/css/ionicons",
          "css!./plugins/font-awesome/4.7.0/css/font-awesome"
        ]
      },
      "backbone": {
        "deps": ["underscore", "jquery"],
        "exports": "Backbone"
      },
      "underscore": {
        "exports": "_"
      },
      "layer": {
        "deps": ["jquery"]
      },
      "slimscroll": {
        "deps": ["jquery"]
      },
      "jquery-loading-indicator": {
        "deps": [
          "jquery",
          "css!./plugins/jquery-loading-indicator/3.3.1/css/jquery.loading-indicator"
        ]
      },
      "icheck": {
        "deps" : [
          "jquery",
          "css!./plugins/icheck/1.0.2/css/skins/flat/_all"
        ]
      },
      "bs-datepicker": {
        "deps" : [
          "css!./plugins/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3"
        ]
      },
      "bs-datepicker-zh": {
        "deps" : [
          "jquery",
          "bs-datepicker"
        ]
      },
      "bs-datetimepicker": {
        "deps": [
          // jquery, moment
          "css!./plugins/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker"
        ]
      },
      "bs-timepicker": {
        "deps": [
          "jquery",
          "css!./plugins/bootstrap-timepicker/0.5.2/css/bootstrap-timepicker"
        ]
      },
      "bs-switch": {
        "deps": [
          "css!./plugins/bootstrap-switch/3.3.4/css/bootstrap3/bootstrap-switch"
        ]
      }
    }
  },  true);
});

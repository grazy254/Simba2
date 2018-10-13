define([
  "dodo",
  "./base-config"
],
  function (dodo, baseConfig) {
    "use strict";
    // package是数组需要单独处理，因为extend对数组是覆盖，
    // 但是实际是需要合并两个数组
    var mergedPackageProp = [{
      name: 'jquery-validate',
      main: 'jquery-validate-main',
      location: './plugins/jquery-validate/'
    }].concat(baseConfig.packages || []);

    var devConfig = dodo.extend(true, {}, baseConfig, {
      "paths": {
        "text": "./requirejs/plugins/text/2.0.15/js/text",
        "i18n": "./requirejs/plugins/i18n/2.0.6/i18n",
        "domReady": "./requirejs/plugins/domready/2.0.1/js/domReady",
        "css": "./requirejs/plugins/css/0.1.10/js/css",

        "jquery": './plugins/jquery/1.12.4/js/jquery',
        "bootstrap3": "./plugins/bootstrap3/3.3.7/js/bootstrap",
        "adminlte": "./plugins/adminlte/2.4.2/js/adminlte",
        "backbone": "./plugins/backbone/1.3.3/js/backbone",
        "backbone-localstorage":"./plugins/backbone.localstorage/1.1.16/js/backbone.localStorage",
        "underscore": "./plugins/underscore/1.9.1/js/underscore",

        "layer": "./plugins/layer/3.1.1/layer",
        "slimscroll": "./plugins/jquery-slimscroll/1.3.8/jquery.slimscroll",
        "fastclick": "./plugins/fastclick/1.3.8/fastclick",
        "jquery-loading-indicator": "./plugins/jquery-loading-indicator/3.3.1/js/jquery.loading-indicator",
        // *** form plugins ***
        // AMD module plugins
        // "jquery-validate":"./plugins/jquery-validate/1.17.0/localization/messages.zh",
        "bs-datetimepicker": "./plugins/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker",
        "bs-datepicker": "./plugins/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker",
        "bs-switch": "./plugins/bootstrap-switch/3.3.4/js/bootstrap-switch",
        "autosize": "./plugins/autosize/4.0.2/js/autosize",
        // not AMD module plugins
        "bs-datepicker-zh": "./plugins/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min",
        "icheck": "./plugins/icheck/1.0.2/js/icheck",
        "bs-timepicker": "./plugins/bootstrap-timepicker/0.5.2/js/bootstrap-timepicker",

        // *** common plugins***
        // AMD module plugins
        "moment": "./plugins/moment/2.22.2/js/moment-with-locales",
        "js-logger": "./plugins/js-logger/1.4.0/js/logger",
        "js-cookie": "./plugins/js-cookie/2.2.0/js/js.cookie",
        "json5": "./plugins/json5/2.2.0/js/json5",
        "localforage": "./plugins/localforage/1.7.2/js/localforage",
        "ajax-hook":"./plugins/ajax-hook/ajaxhook"
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
          // "deps": ["underscore", "jquery"],
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
          "deps": [
            "jquery",
            "css!./plugins/icheck/1.0.2/css/skins/flat/_all"
          ]
        },
        "bs-datepicker": {
          "deps": [
            "css!./plugins/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3"
          ]
        },
        "bs-datepicker-zh": {
          "deps": [
            "jquery",
            "bs-datepicker"
          ]
        },
        "bs-datetimepicker": {
          "deps": [
            // jquery, moment, bootstrap
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
    });

    devConfig.packages = mergedPackageProp;
    return devConfig;
  });

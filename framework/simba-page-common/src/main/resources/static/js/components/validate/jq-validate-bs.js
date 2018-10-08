/**
 * @file bs-jq-validate.js
 * @author betgar (betgar@163.com)
 * @date 09/27/2018
 * @time 16:56:34
 * @description jquery validate default config for bootstrap.
 */
define([
  'jquery',
  'components/validate/jq-validate'
], function ($, validator) {
  'use strict';
  validator.setDefaults({
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('help-block');
      var $formGroup = element.closest('.form-group'),
        $feedback = $formGroup.find('.form-control-feedback');
      $formGroup.find('.help-block').replaceWith(error);
      if ($feedback.length) {
        $feedback.addClass('glyphicon-remove');
      }
    },
    success: function (label, element) {
      var $ele = $(element);
      var $formGroup = $ele.closest('.form-group'),
        $feedback = $formGroup.find('.form-control-feedback');
      if ($feedback.length) {
        $feedback.addClass('glyphicon-remove');
      }
    },
    highlight: function (ele, errorClass, validClass) {
      var $formGroup = $(ele).closest('.form-group');
      var $feedback = $formGroup.find('.form-control-feedback');
      $formGroup.addClass('has-success').removeClass('has-error');
      if ($feedback.length) {
        $feedback.addClass("glyphicon-remove").removeClass("glyphicon-ok");
      }
    },
    unhighlight: function (ele, errorClass, validClass) {
      var $formGroup = $(ele).closest('.form-group');
      var $feedback = $formGroup.find('.form-control-feedback');
      $formGroup.addClass('has-success').removeClass('has-error');
      if ($feedback.length) {
        $feedback.addClass("glyphicon-ok").removeClass("glyphicon-remove");
      }
    }
  });
  return validator;
});

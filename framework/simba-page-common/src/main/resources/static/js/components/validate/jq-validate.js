/**
 * @file jq-validate.js
 * @author betgar (betgar@163.com)
 * @date 09/22/2018
 * @time 20:51:56
 * @description
 */
define(function (require) {
  var envUtils = require('common/utils/env-utils');
  envUtils.isDebug() ? require([
    '../../plugins/jquery-validate/1.17.0/localization/messages_zh',
    '../../plugins/jquery-validate/1.17.0/js/additional-methods'
  ]) : require([
    '../../plugins/jquery-validate/1.17.0/localization/messages_zh.min',
    '../../plugins/jquery-validate/1.17.0/js/additional-methods.min'
  ]);
  return $.validator;
});

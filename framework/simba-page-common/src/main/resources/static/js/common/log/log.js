/**
 * @file log.js
 * @author betgar (betgar@163.com)
 * @date 09/20/2018
 * @time 16:57:23
 * @description This is a logger module, it dependanced js-logger.
 */
define([
  'jquery',
  'js-logger',
  'common/utils/env-utils'
], function ($, Logger, envUtils) {
  'use strict';
  /**
   * global logger options
   */
  var logLevel = envUtils.isDebug() ? Logger.DEBUG : Logger.ERROR;


  var addMessageTime = function (messages) {
    var msg = Array.prototype.slice.call(messages);
    return [].concat((new Date()).toJSON(), msg);
  };

  var consoleHandler = Logger.createDefaultHandler();
  // var remoteServiceHandler = function (messages, context) {
  //   jQuery.post('/logs', { message: messages[0], level: context.level });
  // };

  // set global logger options
  Logger.setLevel(logLevel);
  Logger.setHandler(function (messages, context) {
    var msg = addMessageTime(messages);
    consoleHandler(msg, context);
    // remoteServiceHandler(msg, context);
  });
  return Logger;
});

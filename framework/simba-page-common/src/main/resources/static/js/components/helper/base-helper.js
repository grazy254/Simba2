define([
  'jquery',
  'common/log/log'
], function ($, Logger) {
  'use strict';
  var logger = Logger.get('helper/base-helper');
  /**
   * @typedef {Object} PluginMetadata
   * @property {Function} ctor - 构造函数
   * @property {Object} defaults - plugin全局配置属性
   * @property {Object} [defaultOptions] - 默认配置.
   */

  /**
    * @param  {PluginMetadata} options
    * @return {{defaults: Function, render: Function, callWith: Function}} - helper之类
    */

  function BaseHelper(options) {
    if ($.type(options) !== 'object') {
      throw new Error('BaseHelper need object type options');
    }
    if (!(this instanceof BaseHelper)) {
      return new BaseHelper(options);
    }
    this.metadata = options;

    if ($.type(options.on) === 'function') {
      this.on = options.on;
    }
  }

  // prototype

  /**
   * @param  {Object} option - 配置
   * @return {Object | undefined}
   */
  BaseHelper.prototype.defaults = function (option) {
    if (arguments.length === 1) {
      $.extend(this.metadata.defaults, option || {});
    } else {
      return $.extend(true, {}, this.metadata.defaults);
    }
  };

  /**
   * 渲染(初始化).
   * @param  {HTMLElement | string | jQuery} el - 元素
   * @param  {Object} [options] - 配置项
   * @returns {jQuery}
   */
  BaseHelper.prototype.render = function (el, options) {
    return this.metadata.ctor.call($(el), $.extend(true, {}, this.metadata.defaultOptions, options || {}));
  };


  /**
   * 调用方法.
   * @param  {HTMLElement | string | jQuery} el
   * @param  {string} name - 方法名称
   * @param params - 参数.
   */
  BaseHelper.prototype.callWith = function (el, name, params) {
    var args = $.makeArray(arguments).slice(1);
    return this.metadata.ctor.apply($(el), args);
  };

  /**
   * 绑定事件.
   * @param {HTMLElement | String | jQuery} el - DOM元素；selector；jQuery对象
   * @param {String} events - 事件名称
   * @param {String} [selector] - 子选择器
   * @param {*} [data] - 数据
   * @param {Function} handler - 事件处理函数
   * @return {jQuery}
   */
  BaseHelper.prototype.on = function (el, events, selector, data, handler) {
    var args = $.makeArray(arguments).slice(1);
    return $.fn.on.apply($(el), args);
  };

  return BaseHelper;
});

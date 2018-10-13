/**
 * @file autosize-textarea.js
 * @author betgar (betgar@163.com)
 * @date 09/28/2018
 * @time 16:53:40
 * @description 根据内容自适应高度的textarea.
 */
define([
  'jquery',
  'autosize'
], function ($, autosize) {
  'use strict';
  return {
    /**
     * @param  {jQuery | string | HTMLElement} ele
     * @returns {jQuery}
     */
    autosize: function (ele) {
      var $ele = $(ele);
      $ele.filter('textarea').each(function (index, ele) {
        autosize(ele);
      });
      return $ele;
    }
  };
});

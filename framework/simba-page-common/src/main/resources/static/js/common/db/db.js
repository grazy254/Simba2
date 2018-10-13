/**
 * @file db.js
 * @author betgar (betgar@163.com)
 * @date 09/21/2018
 * @time 11:09:49
 * @description 依赖localforage，使用browser的WebSQL或者IndexedDB
 */

define([
  'localforage'
], function (lf) {
  'use strict';
  var defaultOptions = {
    driver: [
      lf.WEBSQL,
      lf.INDEXEDDB,
      lf.LOCALSTORAGE
    ],
    name: 'lf', // localforage
    // size: 4980736, // 字节单位
    storeName: 'lf-store', // keyvaluepairs
    // version: '1.0',
    description: 'the default db config options.'
  };

  // init localforage config
  lf.config(defaultOptions);

  return lf;
});

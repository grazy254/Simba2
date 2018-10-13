/**
 * @file utils.js
 * @author betgar (betgar@163.com)
 * @date 08/29/2018
 * @time 15:05:11
 * @description
 */

 define(function () {
  "use strict";
  /* eslint-disable eqeqeq, valid-jsdoc */
  var toString = Object.prototype.toString,
      hasOwn = Object.prototype.hasOwnProperty,
      fnToString = hasOwn.toString,
      getProto = Object.getPrototypeOf,
      ObjectFunctionString = fnToString.call(Object);

  /**
   * isObject.
   * @param {*} obj - object
   * @return {boolean} - result
   */
  function isObject(obj) {

    return obj != null && typeof (obj) === 'object' && toString.call(obj) === '[object Object]';
  }

  /**
   * isString
   * @param {*} str
   * @return {boolean}
   */
  function isString(str) {
    return typeof (str) === 'string' && toString.call(str) === '[object String]';
  }

  /**
   * isEmptyString.
   * @param {string} str
   * @return {boolean}
   */
  function isEmptyString(str) {
    return str != null && (str + '').length < 1;
  }

  /**
   * isEmptyTrimmedString
   * @param  {string} str
   * @return {boolean}
   */
  function isEmptyTrimmedString(str) {
    return str != null && (str + '').trim().length < 1;
  }

  /**
   * notEmptyTrimmedString
   * @param  {string} str
   * @return {boolean}
   */
  function notEmptyTrimmedString(str) {
    return !isEmptyTrimmedString(str);
  }

  function isFunction(obj) {
    return typeof obj === "function" && typeof obj.nodeType !== "number";
  }

  /**
   * isEmptyArray
   * @param {Array} list
   * @return {boolean}
   */
  function isEmptyArray(list) {
    return list == null || list.length < 1;
  }

  /**
   * isNull
   * @param {*} obj
   * @return {boolean}
   */
  function isNull(obj) {
    return obj === null;
  }

  /**
   * isNullOrUndefined
   * @param {*} value
   * @return {boolean}
   */
  function isNullOrUndefined(value) {
    return isNull(value) || isUndefined(value);
  }

  /**
   * isUndefined
   * @param {*} value
   * @return {boolean}
   */
  function isUndefined(value) {
    return value === void 0;
  }

  function _extend() {
    var options, name, src, copy, copyIsArray, clone,
      target = arguments[0] || {},
      i = 1,
      length = arguments.length,
      deep = false;

    // Handle a deep copy situation
    if (typeof target === "boolean") {
      deep = target;

      // Skip the boolean and the target
      target = arguments[i] || {};
      i++;
    }

    // Handle case when target is a string or something (possible in deep copy)
    if (typeof target !== "object" && !isFunction(target)) {
      target = {};
    }

    // Extend jQuery itself if only one argument is passed
    if (i === length) {
      target = this;
      i--;
    }

    for (; i < length; i++) {

      // Only deal with non-null/undefined values
      if ((options = arguments[i]) != null) {

        // Extend the base object
        for (name in options) {
          src = target[name];
          copy = options[name];

          // Prevent never-ending loop
          if (target === copy) {
            continue;
          }

          // Recurse if we're merging plain objects or arrays
          if (deep && copy && (isPlainObject(copy) ||
            (copyIsArray = Array.isArray(copy)))) {

            if (copyIsArray) {
              copyIsArray = false;
              clone = src && Array.isArray(src) ? src : [];

            } else {
              clone = src && isPlainObject(src) ? src : {};
            }

            // Never move original objects, clone them
            target[name] = _extend(deep, clone, copy);

            // Don't bring in undefined values
          } else if (copy !== undefined) {
            target[name] = copy;
          }
        }
      }
    }

    // Return the modified object
    return target;
  }

  function isPlainObject(obj) {
    var proto, Ctor;

    // Detect obvious negatives
    // Use toString instead of jQuery.type to catch host objects
    if (!obj || toString.call(obj) !== "[object Object]") {
      return false;
    }

    proto = getProto(obj);

    // Objects with no prototype (e.g., `Object.create( null )`) are plain
    if (!proto) {
      return true;
    }

    // Objects with prototype are plain iff they were constructed by a global Object function
    Ctor = hasOwn.call(proto, "constructor") && proto.constructor;
    return typeof Ctor === "function" && fnToString.call(Ctor) === ObjectFunctionString;
  }

  return {
    isUndefined: isUndefined,
    isNullOrUndefined: isNullOrUndefined,
    isNull: isNull,
    isEmptyArray: isEmptyArray,
    notEmptyTrimmedString: notEmptyTrimmedString,
    isEmptyTrimmedString: isEmptyTrimmedString,
    isEmptyString: isEmptyString,
    isString: isString,
    isObject: isObject,
    isPlainObject: isPlainObject,
    extend: _extend,
    // TODO:
    // each, trim
    // makeArray
    // isArrayLike
  };
});

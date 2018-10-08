define([
  'jquery'
], function ($) {
  'use strict';

  var upperFirstLetter = function (str) {
    if (typeof (str) === 'string' && str) {
      return str.slice(0, 1).toUpperCase().concat(str.slice(1));
    } else {
      return str;
    }
  };
  var genTypeDef = {

    /**
     * @param  {Object} obj
     * @param  {{name: string}} options
     */
    gen: function (obj, options) {
      var strs = [];
      strs.push('\/** \n');
      strs.push(' * @typedef { ' + upperFirstLetter($.type(obj)) + ' }' + ' ' + options.name + '\n');
      strs.push(this.genProp(obj).join(''));
      strs.push(' *\/');
      return strs.join('');
    },

    /**
     * @param  {Object} obj
     * @param  {string} context
     */
    genProp: function (obj, context) {
      var strs = [], key, value, valueType = '';
      context = context ? (context + '.') : '';
      for (key in obj) {
        if (obj.hasOwnProperty(key)) {
          value = obj[key], valueType = $.type(value);
          switch (valueType) {
            case 'undefined':
            case 'null':
              strs.push(' * @property ' + '{*}  [' + context + key + '] \n');
              break;
            case 'function':
            case 'date':
              strs.push(' * @property ' + '{' + upperFirstLetter(valueType) + '}  [' + context + key + '] \n');
              break;
            case 'array':
              strs.push(' * @property ' + '{' + upperFirstLetter(valueType) + '}  [' + context + key + ' = ' + JSON.stringify(value) + '] \n');
              break;
            case 'object':
              strs.push(' * @property ' + '{' + upperFirstLetter(valueType) + '}  [' + key + '] \n');
              strs.push(this.genProp(value, key).join(''));
              break;
            default:
              strs.push(' * @property ' + '{' + upperFirstLetter(valueType) + '}  [' + context + key + ' = ' + value + '] \n');
              break;
          }
        }
      }

      return strs;
    }
  };

  return genTypeDef;
});

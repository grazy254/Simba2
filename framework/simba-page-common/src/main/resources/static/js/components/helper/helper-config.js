/**
 * @file helper-config.js
 * @author betgar (betgar@163.com)
 * @date 09/20/2018
 * @time 09:34:57
 * @description 配置plugin helper和requirejs config的paths配置的名称的映射关系
 */

define([
  'jquery',
  'dodo'
], function ($, dodo) {
  var configs = {// name: require.config path的name, value对应的plugin的helper名称
    'bs-switch': 'components/helper/bs-switch-config',
    'bs-datepicker': 'components/helper/bs-datepicker-config',
    'bs-timepicker': 'components/helper/bs-timepicker-config',
    'bs-datetimepicker': 'components/helper/bs-datetimepicker-config',
    'icheck': 'components/helper/icheck-config'

  };
  return {
    /**
     * 获取或者设置配置.
     * @param  {string | Object} [name]
     * @param  {string} [value]
     * @return {string | Object}
     */
    config: function (name, value) {
      var length = arguments.length, result;
      switch (length) {
        case 1:
          if (dodo.isObject(name)) {
            dodo.extend(configs, name);
            result = dodo.extend(true, {}, configs);
          } else {
            result = configs[name];
          }
          break;
        case 2:
          result = configs[name];
          configs[name] = value;
          break;
        default:
          result = dodo.extend(true, {}, configs);
          break;
      }
      return result;
    },

    /**
     * 判断是否存在.
     * @param  {string} name - 名称
     * @return {boolean}
     */
    has: function (name) {
      return dodo.notEmptyTrimmedString(configs[name]);
    }
  };
});

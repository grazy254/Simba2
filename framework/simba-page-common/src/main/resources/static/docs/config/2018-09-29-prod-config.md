# prod-config

> `prod-config`：配置了`requirejs`中的`config`的模块信息，配置的模块是压缩版本。



## 内容

> 内容如下，当开发时，参考模块名.



```javascript
{
    "paths": {
      // requirejs plugins
      "text": "./requirejs/plugins/text/2.0.15/js/text.min",
      "i18n": "./requirejs/plugins/i18n/2.0.6/i18n.min",
      "domReady": "./requirejs/plugins/domready/2.0.1/js/domReady.min",
      "css": "./requirejs/plugins/css/0.1.10/js/css.min",
      // *** libraries plugins ***
      "jquery": './plugins/jquery/1.12.4/js/jquery.min',
      "bootstrap3": './plugins/bootstrap/3.3.7/js/bootstrap.min',
      "adminlte": './plugins/adminlte/2.4.2/js/adminlte.min',
      "backbone": "./plugins/backbone/1.3.3/js/backbone-min",
      "underscore": "./plugins/underscore/1.9.1/js/underscore-min",
      "layer": "./plugins/layer/3.1.1/layer",

      // *** form plugins ***
      // AMD module plugins
      "bs-datetimepicker": "./plugins/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min",
      "bs-datepicker": "./plugins/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min",
      "bs-switch": "./plugins/bootstrap-switch/3.3.4/js/bootstrap-switch.min",
      // not AMD module plugins
      "bs-datepicker-zh": "./plugins/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min",
      "icheck": "./plugins/icheck/1.0.2/js/icheck.min",
      "bs-timepicker": "./plugins/bootstrap-timepicker/0.5.2/js/bootstrap-timepicker.min",
      "autosize": "./plugins/autosize/4.0.2/js/autosize.min",

      // *** common UI plugins ***
      "slimscroll": "./plugins/jquery-slimscroll/1.3.8/jquery.slimscroll",
      "fastclick": "./plugins/fastclick/1.3.8/fastclick",
      "jquery-loading-indicator": "./plugins/jquery-loading-indicator/3.3.1/js/jquery.loading-indicator.min",

      // *** common plugins ***
      "moment": "./plugins/moment/2.22.2/js/moment-with-locales.min",
      "js-logger": "./plugins/js-logger/1.4.0/js/logger.min",
      "js-cookie": "./plugins/js-cookie/2.2.0/js/js.cookie.min",
      "json5": "./plugins/json5/2.2.0/js/json5.min",
      "localforage": "./plugins/localforage/1.7.2/js/localforage.min"
    }
}
```



## 依赖使用

```javascript
// 根据模块信息依赖模块
// 定义模块时依赖
define(['js-logger'], function (Logger) {
    // 打印日志
    Logger.log('打印测试');
    
    // 获取打印实例
    var devConfigLogger = Logger.get('devConfig');
    devConfigLogger.log('来自dev-config的信息');
});

// 使用模式的依赖
require(['js-logger'], function (Logger){
    Logger.log('require func log ...');
});


```
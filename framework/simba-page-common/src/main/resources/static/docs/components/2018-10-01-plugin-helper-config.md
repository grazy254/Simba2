---
title: plugin-config配置文件
date: 2018-09-30 22:00:00
tag: dodo
category: dodo
---

# plugin config配置文件

> plugin config的主要作用，**对已有的组件**进行**公共全局配置**，防止重复劳动，输出统一的**[base-helper-options](components/2018-10-01-the-helper?id=options配置)**配置对象，供**BaseHelper**使用。



## 配置文件

> 因为plugin config配置文件起到**公共配置的作用** 所以不应该做过多的逻辑处理，配置文件有着**特殊约定**。



### 约定

返回值约定：**plugin config**模块的返回值必须是**[base-helper-options](components/2018-10-01-the-helper?id=options配置)**配置对象。



### 内容结构

> 内容结构没有特殊的要求，唯一要求就是**返回值约定**。



```javascript
// 模板
define([
    'jQuery',
    'bs-datepicker-zh', // requirejs中配置的组件别名
], function ($){
    // 重置 组件全局默认配置
    // .....
    
    // 返回 BaseHelper需要的options结构
    return {
        ctor: $.fn.datepicker, // 构造函数
        defaults: $.fn.datepicker.defaults, // 指向全局的默认配置
        defaultOptions: {}
    };
});
```





```javascript
// 例子
// plugin config配置多数情况下配置的是第三方组件（jQuery plugins）
define([
  'jquery',
  'bs-datepicker-zh' // requirejs的config配置别名，具体参考配置文件
], function ($) {
  'use strict';
  // 这里主要做一些重置组件全局配置的逻辑，不能出现任何其他的业务逻辑
  var defaultOptions = function () {
    return {
      format: 'yyyy-mm-dd',
      language: 'zh-CN',
      autoclose: true
    };
  };
    
  // 重置全局配置
  $.fn.datepicker.dates["zh-CN"].format = 'yyyy-mm-dd';
  
  // 约定：返回BaseHelper需要的options参数结构 
  return {
    ctor: $.fn.datepicker,
    defaults: $.fn.datepicker.defaults,
    defaultOptions: defaultOptions()
  };
});

```



## 使用

> 这里以`datepicker`为例子，进行操作。
>
> [可以对比一下base-helper中的使用例子](/components/2018-09-30-the-helper-module?id=使用)

### 通过`BaseHelper`使用`config`配置

```javascript
// 定义BaseHelper需要的options参数
define([
    'components/helper/base-helper',
    'components/helper/bs-datepicker-config'
], function (BaseHelper, datepickerConfig){
    var datepickerHelper = new BaseHelper(datepickerConfig);
    
    // 以下部分和base-helper 使用章节一样
    // 初始化
    // 等价于 $('input[type="text"]').datepicker({autoclose: false});
    datepickerHelper.render('input[type="text"]', {
        autoclose: false
    });
    
    // 方法
    // 等价于var now = $('input[type="text"]').datepicker('getDate');
    var now = datepickerHelper.callWith('input[type="text"]', 'getDate');
    
    // 等价于 $('input[type="text"]').datepicker('setDate', now);
    datepickerHelper.callWith('input[type="text"]', 'setDate', now);
    
    // 事件
    // 等价于 $('input[type="text"]').datepicker('changeDate', function(){});
    datepickerHelper.on('input[type="text"]', 'changeDate', function (){});
    
    // 改变组件全局默认options配置
    // 等价于 $.fn.datepicker.defaults.format = 'yyyy-mm-dd'
    datepickerHelper.defaults({
        format: 'yyyy-mm-dd'
    });
    
    // 也可以使用 原来的jQuery plugin的方式使用
    $('input[type="text"]').datepicker(datepickerConfig.dafaultOptions);
});

```



### 通过组件**构造函数**使用`config`

```javascript
define([
    'components/helper/bs-datepicker-config'
], function (datepickerConfig){
    // 也可以使用 原来的jQuery plugin的方式使用
    $('input[type="text"]').datepicker(datepickerConfig.dafaultOptions);
});
```


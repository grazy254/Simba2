---
title: helper模块
date: 2018-09-30 22:00:00
tag: dodo
category: dodo
---

# helper模块

> helper模块的主要作用，**对已有的组件**轻度的封装，**设置全局配置**，方便使用，防止重复劳动，对外提供统一的接口。



## BaseHelper

> `BaseHelper`是创建`helper`的基类，`BaseHelper`使用`*-config.js`的配置作为输入，输出组件的`helper`实例。



### options配置

> `options`的配置没有固定的结构，具体看`组件的options配置项`。

| 名称           | 类型     | 可选 | 默认值   | 备注                         |
| -------------- | -------- | ---- | -------- | ---------------------------- |
| on             | Function | Y    | function | 提供绑定**事件**的处理逻辑。 |
| ctor           | Function |      |          | 组件默认构造函数             |
| defaults       | Object   |      | Object   | 默认指向**组件的全局配置**   |
| defaultOptions | Object   |      | Object   | 默认公共**配置部分**         |



## 方法

> 所有的第三方**组件**进行适配，统一接口。

| 名称     | 参数       | 类型                            | 可选 | 默认值 | 返回值 | 备注                                |
| -------- | ---------- | ------------------------------- | ---- | ------ | ------ | ----------------------------------- |
| defaults | [options]  | Object                          | Y    | --     | Object | 获取或者设置**组件的全局配置**      |
| render   | el         | string / jQuery  /  HTMLElement |      |        | jQuery | 渲染组件或者改变组件的`options`配置 |
|          | [options]  | Object                          | Y    | --     |        |                                     |
| callWith | el         | string / jQuery  /  HTMLElement |      |        | *      | 调用组件的**方法**                  |
|          | name       | string                          |      |        |        |                                     |
|          | param      | *                               |      |        |        |                                     |
| on       | el         | string / jQuery  /  HTMLElement |      |        |        | 给组件绑定**事件**的方法。          |
|          | events     | string                          |      |        |        | 事件名称                            |
|          | [selector] | string                          |      |        |        | 选择器                              |
|          | [data]     | *                               |      |        |        | 数据                                |
|          | handler    | Function                        |      |        |        | 事件处理函数                        |



## 使用

> 这里以`datepicker`为例子，进行操作。

```javascript
// 定义BaseHelper需要的options参数
define([
    'components/helper/base-helper',
    'bs-datepicker-zh'
], function (BaseHelper){
    var options = {
       ctor: $.fn.datepicker, // 必须知道组件的构造函数
       default: $.fn.datepicker.defaults, // 必须知道组件的全局默认配置
       // defaultOptions用来覆盖 默认全局配置，这部分是公共通用的，才这样使用 
       defaultOptions: {
         format: 'yyyy-mm-dd',
     	 language: 'zh-CN',
     	 autoclose: true
    	}
    };
    
    var datepickerHelper = new BaseHelper(options);
    
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
});

```



> `BaseHelper`需要的**options**配置，可以形成配置文件的方式，方便重用，减少重复代码。
>
> 具体看**配置的相关文档**。
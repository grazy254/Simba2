---
title: helper
date: 2018-010-01 22:00:00
tag: dodo
category: dodo
---

# helper组件

> helper组件的主要作用是**异步加载**组件的**config**配置文件，优化加载速度。



## options配置

> 无.



## 方法

> helper是一个工厂，加载组件配置文件只需要一个类型**type**.

| 名称    | 参数         | 类型   | 可选 | 默认值 | 返回值     |
| ------- | ------------ | ------ | ---- | ------ | ---------- |
| fectory | options      | Object |      | --     | $.Deferred |
|         | options.type | string |      |        |            |

> `options.type`：参考`helper-config`映射表中的`key`.



## 事件

> 无



## 加载流程图

> 如下



## 使用

> 这里以`datepicker`为例子，进行操作。

```javascript
// 定义BaseHelper需要的options参数
define([
    'components/helper/helper'
], function (helper){
    /* 等价于
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
    */
    // 异步加载渲染组件配置文件
    helper.factory({
        type: 'bs-datepicker'
    }).then(function (datepickerHelper){
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
    }); // end helper factory
    
    
});

```



## 优缺点

> `helper`动态加载**组件config配置**的也是有使用**场景**限制。

### 优点

> 速度：异步加载，方便速度快，统一出入口。



### 缺点

> 流程：打乱代码的执行流程，多组件协同难以处理。
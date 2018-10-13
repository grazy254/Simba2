---
title: helper-config配置
date: 2018-09-30 22:00:00
tag: dodo
category: dodo
---

# helper-config

> helper-config是**组件config配置**的映射表管理组件。helper-config内部通过一个`HashMap`结构来保存当前有哪些**组件的配置文件**，方便通过`helper`组件使用。



## `组件config`配置文件

> 列出**组件的config配置文件**在`helper-config`中的映射。
>
> 映射规约：key使用`requirejs`的`config`配置中的`key`，value是配置文件`相对于baseUrl`的路径。

```javascript
// 映射表
{
    // name: require.config 中的name, value对应的plugin的config文件路径
    'bs-switch': 'components/helper/bs-switch-config',
    'bs-datepicker': 'components/helper/bs-datepicker-config',
    'bs-timepicker': 'components/helper/bs-timepicker-config',
    'bs-datetimepicker': 'components/helper/bs-datetimepicker-config',
    'icheck': 'components/helper/icheck-config'
}
```



## options配置

> 无



## 方法

> config方法：是`helper-config`的**获取**或者**添加** ，**组件config配置文件** 的统一入口。
>
> has：是判断`helper-config`内部是否配置了**组件config**的方法。

| 名称   | 参数    | 类型     | 可选 | 默认值 | 返回值 | 备注                     |
| ------ | ------- | -------- | ---- | ------ | ------ | ------------------------ |
| config | [name]  | string   | Y    | --     |        | 获取或者设置映射表中的值 |
|        | [value] | *        | Y    |        |        |                          |
| has    | name    | string   |     | --     |        |判断是否存在组件配置|





## 使用

> 这里以`datepicker`为例子，进行操作。

```javascript
define([
    'components/helper/helper-config'
], function (helperConfig){
    // 获取bs-switch对应的config的模块名
    var configFileModule = helperConfig.config('bs-switch');
    // 获取全部的配置表
    var pluginsConfig = helperConfig.config();
    // 设置bs-switch的模块名
    helperConfig.config('bs-switch', 'components/helper/bs-switch-config');
    
    // 设置多个值
    helperConfig.config({
        'bs-switch': 'components/helper/bs-switch-config',
        'bs-datepicker': 'components/helper/bs-datepicker-config'
    });
    
    // 判断是否包含某个组件配置
    helperConfig.has('bs-switch');
   
});

```



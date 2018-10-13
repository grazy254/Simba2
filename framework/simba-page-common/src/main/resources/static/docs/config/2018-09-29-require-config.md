# require-config模块

> `require-config`模块是管理，requirejs需要的config信息的入口。



## options配置项

> 无



## 方法

| 名称    | 参数         | 类型   | 默认值 | 返回值 | 备注                                      |
| ------- | ------------ | ------ | ------ | ------ | ----------------------------------------- |
| fetchBy | globalConfig | Object | --     | Object | 返回prod-config或者dev-config中的配置对象 |



```javascript
define(['config/require-config'], function (requireConfig) {
    // require-config模块一般情况下，不直接使用，应该通过config模块来访问
    var devConfig = requireConfig.fetchBy({
        envMode: 'dev'
    });
    
    var prodConfig = requireConfig.fetchBy({
        envMode: 'prod'
    });
});
```



> fetchBy用来根据`globalConfig.envMode`返回`prod-config`或者是`dev-config`中的内容。
>
> config模块的`config.fetch()`内部就是调用了`require-config.fetchBy()`来获取配置的。



## 事件

> 无
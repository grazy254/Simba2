# base-config

> base-config：配置了`requirejs`需要的`config`中需要的公共部分，`dev-config`和`prod-config`不需要重新配置。



## 内容

> `base-config`中的公共模块信息

```javascript
{
    packages: [
      {
        name: "dodo",
        main: "dodo"
      },
      {
        name: "config",
        main: "config"
      }
    ],
    waitSeconds: 5,
    paths: {
      // *** folder ***
      "components": "./components/",
      "common": "./common/"
    }
  }
```



## 使用

> `base-config`中配置了部分`packages`模块

```javascript
define(['dodo', 'config'], function (dodo, config) {
    var isObject = dodo.isObject({id: 1});
    
    // 获取合并之后的globalConfig
    var mergedGlobalConfig = config.store().globalConfig;
});
```


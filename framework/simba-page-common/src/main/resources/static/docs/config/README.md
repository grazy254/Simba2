# config模块

> config模块：config模块是一个非常重要的模块，config用来提供一些前端模块的全局配置。
>
> config模块管理了，`global-config`和`require-config`配置。



## config入口

> config模块的入口是`config.js`，可以通过config模块来存取global-confing的配置，以及prod-config和dev-config中的配置。



## require-config模块

> 用来是用来专门管理`requirejs`使用的模块`config`配置，`requirejs`中的使用的所有的模块信息全部在
>
> `base-config`,`dev-config`和`prod-config`中配置。



## base-config

> `base-config`：配置了公共模块的信息，最大化重用，防止重复配置。



## dev-config

> `dev-config`: 配置了调试开发模式下模块信息，这里配置的插件都是未压缩的代码。



## prod-config

> `prod-config`： 配置的是生产模式下的模块信息，配置的模块版本都是经过压缩过的，减少传输体积。
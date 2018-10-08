# `jQuery组件库`

> `jQuery组件库`，使用`docsify`搭建。
>
> maintained by ljn.



**NOTE:**

​	请使用`Chrome`或者`Firefox`等现代浏览器打开，其它浏览器不保证**没问题**。

​        **缓存问题解决方案**，详情见[blog注意事项](2018-06-04-note.md)





## 目录结构

> 组件库的目录结构

```
static/
        ├── css
        ├── example
        ├── index.html
        ├── index.js
        ├── js        
        └── pages


```

### `js`目录结构

> `js`目录主要来放置静态JavaScript文件

```
js/
    ├── common           # 公共方法、公共组件
    ├── components       # 业务无关的公共UI组件
    ├── config           # 配置模块，管理全局配置和`requirejs`的配置
    ├── dodo             # 无依赖的公共方法模块
    ├── initiator.js     # 初始化器，根据global-config配置，初始化requirejs需要的配置
    ├── plugins          # 放置第三方的插件（jQuery 插件全在这里放置）
    └── requirejs        # requirejs模块。requirejs + plugins

```


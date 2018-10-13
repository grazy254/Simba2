# requirejs的快速入门

> 阮一峰老师的入门系列。

[RequireJS和AMD规范](http://javascript.ruanyifeng.com/tool/requirejs.html)

[Javascript模块化编程（一）：模块的写法](http://www.ruanyifeng.com/blog/2012/10/javascript_module.html)

[Javascript模块化编程（二）：AMD规范](http://www.ruanyifeng.com/blog/2012/10/asynchronous_module_definition.html)

[Javascript模块化编程（三）：require.js的用法](http://www.ruanyifeng.com/blog/2012/11/require_js.html)

## AMD规范

> `AMD`规范对`loader`，`loader plugins`， `require`有详细的规定。详情见[ AMD 规范wiki](https://github.com/amdjs/amdjs-api/wiki)，这里还有中文版。



### define函数

`define(id?, dependencies?, factory)`

> require, exports, module 三个模块是**顶级模块**。

例子：

创建一个名为"alpha"的模块，使用了require，exports，和名为"beta"的模块:

```javascript
   define("alpha", ["require", "exports", "beta"], function (require, exports, beta) {
       exports.verb = function() {
           return beta.verb();
           //Or:
           return require("beta").verb();
       }
   });
```

一个返回对象的匿名模块：

```javascript
   define(["alpha"], function (alpha) {
       return {
         verb: function(){
           return alpha.verb() + 2;
         }
       };
   });
```

一个没有依赖性的模块可以直接定义对象：

```javascript
   define({
     add: function(x, y){
       return x + y;
     }
   });
```

一个使用了简单CommonJS转换的模块定义：

```javascript
   define(function (require, exports, module) {
     var a = require('a'),
         b = require('b');

     exports.action = function () {};
   });
```





### require函数

```javascript
define(['require'], function (require) {
    //the require in here is a local require.
});

define(function (require, exports, module) {
    //the require in here is a local require.
});

define(function () {
    var $ = require('jquery'); // 全局require
});
```

全局require函数作用于全局，和define()类似。 全局require和局部require有着相同的行为，包含以下特征：

- 模块ID应该认为是一个绝对的模块名称，而不是相对另一个模块的ID。
- 只有在异步的时候，才可以使用require(id, callback?)的回调形式。因为异步加载模块的方式是先发出一个异步请求，然后等主线程代码段执行完毕才能进行异步回调来处理加载好的模块。

#### require(String)

> 如果模块没有加载或者执行完成，就会抛出错误。特别需要指出的是，在同步加载的回调中，如果模块没有加载完成，禁止动态的获取模块，否则，就会抛出异常。
>
> 使用define()定义模块时，依赖项中可以找到一个AMD模块：



```javascript
 define(function (require) {
        var a = require('a');
    });
```

#### require(Array, Function)

> 根据参数，**同步**地返回模块ID所代表的模块。
>
> 参数Array是一个由模块ID组成的数组。当模块ID所以代表的模块加载完成且可用时，回调函数Function才开始执行，并且只被执行一次。各个模块按照依赖数组中的位置顺序以参数的形式传入到Function里。



```javascript
define(function (require) {
        require(['a', 'b'], function (a, b) {
            //modules a and b are now available for use.
        });
    }); 
```



#### require.toUrl(String)

> 将形如**[module ID] + '.extension'**这种字符形式转化成URL路径。
>
> require.toUrl()方法采用通用的模块ID路径转化规则,将模块ID字符解析成URL路径.但它不支持以".js"这种扩展形式。所以，我们必须将'.extension'添加到了解析路径里。



```javascript
  //cart.js contents:
    define (function(require) {
        // 模块ID名 './templates/a'
        // 扩展名 '.html'
        // 模板路径大致以这样的形式结尾 'modules/cart/templates/a.html'
        var templatePath = require.toUrl('./templates/a.html');
    });
```



### config配置

公共项:

- 模块id前缀：

  ```
  some/very/long/name
  ```

  例如：以下都是模块id前缀:

  - `some`
  - `some/very`
  - `some/very/long`
  - `some/very/long/name`

- **模块id前缀的第一个段**: 模块id，从第一个 `/`作为分割，之前的字符串部分全是。 

#### baseUrl

> 字符串类型。给id到path转换指定一个根目录 。

```javascript
{
    baseUrl: './js'
}
```



#### paths

> 对象类型。给模块id前缀(module ID prefix)**显式**指定一个路径(path)。
>
> paths对象的属性是一个**绝对**的模块ID前缀(module ID prefix)，属性值可以是：
>
> 字符串：字符串值是一个**相对于baseUrl的路径**。也可以是一个绝对路径，只要以 `/或者//或者http`开头。
>
> 数组：可选。提供一个可选的容错功能。如果数组第一个路径加载失败，则可以尝试从下一个路径加载，以此类推。



```javascript
// 路径： js/lib/jquery.js
{
    paths: {
        jquery: './lib/jquery'
        bootstrap: [
            'https://cdn/bootstrap',
            './lib/bootstrap'
        ]
    }
}
```



#### packages

package 配置对象的值是一个数组。因为CommonJS规范和AMD规范的loader查找路径方式的差异，所以package配置对象是为了使用实现了CommonJS规范的包。



**默认的查找规则**：`baseUrl + 'module/id' + .js`，其中`paths`配置可以用来映射`module/id`到另一个路径。

**包的查找规则**：使用了一个`packageName`。所以一个包的主模块就是`baseUrl + 'packageName' + .js`

> `main.js`默认作为一个package的入口.

```
baseUrl + (packageConfig.location || 'packageName') + '/' + (packageConfig.main || 'main') + '.js'
```



对于`packageName/otherId`，规则和paths相似，但是`packageConfig`是这样实现的：

```
baseUrl + (packageConfig.location || 'packageName') + '/' + 'otherId' + '.js'

```

package 配置对象可以是：

- 字符串：例如：`bootstrap/modal`：其中`bootstrap`是`packageName`名称，`boostrap/modal`也是一个`packageName`。依赖`bootstrap/modal`时，查找规则如下：

  ```
  baseUrl + `bootstrap/modal` + main.js`
  ```

- 对象: a configuration object that can have the following properties:
  - **name**: 字符串. 解析规则同**上述字符串解析规则一样**.
  - **location**: 字符串，可选.相对于`baseUrl`的路径。
  - **main**: 字符串. 可选.指定包入口。 默认为`main`

```javascript
{   
	packages: [
    	'main',
        {
            name: 'dojo',
            location: 'dojo/1.7.1',
            main:'main'
        }
    ]
}
```



#### config

> 用来模块间传递一些信息使用的。

```javascript
{
    config: {
        'some/module/id': {
            limit: 40
        }
    }
}
```

```javascript
define(['some/module/id'], function (someModule) {
    someModule.config().limit === 40 // true
});
```



#### shim

> 解决那些非`AMD模块`之间的依赖。

```javascript
{
    shim: {
        //This version just specifies the
        //dependency for the jQuery plugin. 
        //Some implementations may be able to do
        //better error correction in older IE if
        //you specify the exports string value,
        //which in this case would be
        //exports: 'jQuery.fn.rotator'
        'jquery.rotator': ['jquery'],

        underscore: {
            exports: '_'
        },

        backbone: {
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        }
    }
}
```



#### map

> 解决模块间同时依赖不同版本的问题。
>
> **限制**： 这个功能只能用于那些，真正使用`define()`定义的AMD 模块并且是**匿名模块**.

```javascript
{
    map: {
        '*': {
            'foo': 'foo1.2'
        },
        'some/oldmodule': {
            'foo': 'foo1.0'
        }
    }
}
```



```javascript
{
    map: {
        'some/newmodule': {
            'foo': 'foo1.2'
        },
        'some/oldmodule': {
            'foo': 'foo1.0'
        }
    }
}
```





## requirejs

> 路径解析：`baseUrl+paths`； 
>
> `/`  ,   `http:`或者`https:`，`.js`结尾的除外。
>
> requirejs加载脚本**非依赖顺序加载**，执行时是**顺序执行**。



### data-main入口



### define函数

#### 定义一个对象

```javascript
define({
	name: 'test'
});
```



#### 定义一个函数

```javascript
define(function () {
    // 初始化工作
    
    return {
        name: 'test'
    };
});
```



#### requirejs.undef

> 使用的场景比较少，主要在**模块加载失败**时使用较多

```javascript
// 官方的demo
requirejs.config({
    enforceDefine: true,
    paths: {
        jquery: 'http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min'
    }
});

//Later
require(['jquery'], function ($) {
    //Do something with $ here
}, function (err) {
    //The errback, error callback
    //The error has a list of modules that failed
    var failedId = err.requireModules && err.requireModules[0];
    if (failedId === 'jquery') {
        //undef is function only on the global requirejs object.
        //Use it to clear internal knowledge of jQuery. Any modules
        //that were dependent on jQuery and in the middle of loading
        //will not be loaded yet, they will wait until a valid jQuery
        //does load.
        requirejs.undef(failedId);

        //Set the path to jQuery to local path
        requirejs.config({
            paths: {
                jquery: 'local/jquery'
            }
        });

        //Try again. Note that the above require callback
        //with the "Do something with $ here" comment will
        //be called if this new attempt to load jQuery succeeds.
        require(['jquery'], function () {});
    } else {
        //Some other error. Maybe show message to the user.
    }
});
```





#### requirejs.config

> `requirejs`的配置项，内容较多，参考[reqquirejs.org](https://requirejs.org/docs/api.html)



#### require.toUrl

> 获取模块的路径。

```javascript
// 官方demo
define(["require"], function(require) {
    var cssUrl = require.toUrl("./style.css");
});
```


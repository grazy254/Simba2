# components模块

> components模块：主要用来放置**业务无关**的`UI`组件。
>



## 子模块

> components模块内部的**子组件**复杂度比较高的，会重新分解，形成**子模块**。



### helper模块

> helper模块：主要是用来引用**第三方**组件，并且做一些公共的通用配置，减少重复劳动。



## 组件



### loader

> loader： 是加载动画组件。



### textarea

> textarea: 是专门对`<textarea>`优化过的组件，达到根据**文字内容**自动适应高度。



### validate

> validate: 组件只是对了`jquery-validate`做了一些全局配置，适配`bootstrap`的布局。
>
> 使用时，对**表单**标签结构有**固定**要求。
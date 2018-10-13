define(function () {
  'use strict';
  var adminlteOptions = {
    // 添加slimscroll.js到导航菜单，在每个页面的app.js加载之前
    navbarMenuSlimscroll: true,
    // scroll bar的width
    navbarMenuSlimscrollWidth: "3px",
    // inner menu的height
    navbarMenuHeight: "200px",

    // 通用的动画速度，例如box的collapse/expend和sidebar treeview的slid up/down
    // 这个选项接受毫秒整数或者 fast, normal, slow
    animationSpeed: 500,
    // sidebar中的push menu 触发器的选择器
    sidebarToggleSelector: "[data-toggle='offcanvas']",
    // 激活状态的sidebar的push menu
    sidebarPushMenu: true,
    // 如果设置fixed layout，激活sidebar的slimscroll
    sidebarSlimScroll: true,
    // 开启 sidebar mini的expand悬浮特效
    // 这个选项在fixed layout和sidebar mini同时使用的时候强制设置为true
    sidebarExpandOnHover: false,
    // 开启 BoxRefresh 插件
    enableBoxRefresh: true,
    // 开启bootstrap.js的tooltip插件
    enableBSToppltip: true,
    // bootstrap tooltip的选择器
    BSTooltipSelector: "[data-toggle='tooltip']",
    // 开启fast click, fastclick.js 在触控设备上创建了一个更原生的触控体验
    // 如果你开启了，确保在app.js加载之前加载fastclick.js
    enableFastclick: true,
    //Control Sidebar Tree Views
    // 开启控制 sidebar tree views
    enableControlTreeView: true,
    // 开启 控制sidebar
    enableControlSidebar: true,
    // control sidebar options
    controlSidebarOptions: {
      // 触发sidebar open/close事件的button选择器
      toggleBtnSelector: "[data-toggle='control-sidebar']",
      // sidebar 选择器
      selector: ".control-sidebar",
      // 开启slide over content
      slide: true
    },
    // 开启这个选项允许box的collapsed 和 removed效果
    enableBoxWidget: true,
    //Box Widget plugin options
    boxWidgetOptions: {
      boxWidgetIcons: {
        // 折叠的图标
        collapse: 'fa-minus',
        // 展开图标
        open: 'fa-plus',
        // 移除图标
        remove: 'fa-times'
      },
      boxWidgetSelectors: {
        // 移除按钮的选择器
        remove: '[data-widget="remove"]',
        // 折叠按钮的选择器
        collapse: '[data-widget="collapse"]'
      }
    },
    // Direct Chat plugin options
    directChat: {
      // 开启direct chat插件
      enable: true,
      // 开启或关闭聊天联系人窗口的button选择器
      contactToggleSelector: '[data-widget="chat-pane-toggle"]'
    },
    //Define the set of colors to use globally around the website
    // 定一个站点的全局一个颜色集合
    colors: {
      lightBlue: "#3c8dbc",
      red: "#f56954",
      green: "#00a65a",
      aqua: "#00c0ef",
      yellow: "#f39c12",
      blue: "#0073b7",
      navy: "#001F3F",
      teal: "#39CCCC",
      olive: "#3D9970",
      lime: "#01FF70",
      orange: "#FF851B",
      fuchsia: "#F012BE",
      purple: "#8E24AA",
      maroon: "#D81B60",
      black: "#222222",
      gray: "#d2d6de"
    },
    //The standard screen sizes that bootstrap uses.
    //If you change these in the variables.less file, change
    //them here too.
    screenSizes: {
      xs: 480,
      sm: 768,
      md: 992,
      lg: 1200
    }
  };

  return adminlteOptions;
});

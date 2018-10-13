# jQuery Loading Indicator Plugin

------

A small plugin to add an loading indicator to your page via javascript. You can choose to use an animated GIF or some CSS3 magic. The loader can be added to any block element. It is very easy to customize via css or less.

## Getting Started

------

1.First you have to download all files from github.

2. Add the Stylesheet and Javascript to the head.

```html
<script src="/path/to/jquery.min.js"></script>
<script src="/path/to/jquery.loading-indicator.js"></script>

<link type="text/css" rel="stylesheet" href="/path/to/jquery.loading-indicator.css" />
```

3. Call plugin

```
$('body').loadingIndicator();
```

# Options

------

| Option       | Default                     | Description                                                  |
| ------------ | --------------------------- | ------------------------------------------------------------ |
| useImage     | false                       | Adds image to the wrapper if true. Otherwise it adds a css3 loader. |
| showOnInit   | true                        | shows loader on init                                         |
| loadingImage | "../src/images/loader.gif"  | Path to the loading gif. Only used when `useImage: true`     |
| loadingClass | "loader"                    | class for loader. Only used when `useImage: false`           |
| wrapperClass | "loading-indicator-wrapper" | class for the loading wrapper                                |

**Note!** If you change the **wrapperClass** or **loadingClass**, you've to change it also in the stylesheet.

# Methods

------

| What | How                                                |
| ---- | -------------------------------------------------- |
| get  | var loader = $(selector).data("loadingIndicator"); |
| show | loader.show()                                      |
| hide | loader.hide()                                      |
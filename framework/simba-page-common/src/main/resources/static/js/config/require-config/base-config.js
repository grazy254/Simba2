define(function() {
  "use strict";
  return {
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
      "text": "./requirejs/plugins/text/2.0.15/js/text",
      "i18n": "./requirejs/plugins/i18n/2.0.6/i18n",
      "domReady": "./requirejs/plugins/domready/2.0.1/js/domReady",
      "css": "./requirejs/plugins/css/0.1.10/js/css",
      "jquery": './plugins/jquery/1.12.4/js/jquery',
      // *** folder ***
      "components": "./components",
      "common": "./common"
    }
  };
});

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
      // *** folder ***
      "components": "./components/",
      "common": "./common/",

      // plugins folder
      "jquery-validate": "./plugins/jquery-validate/"
    }
  };
});

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
    skipDataMain: true,
    paths: {
      // *** folder ***
      "components": "./components/",
      "common": "./common/"
    }
  };
});

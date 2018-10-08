require([
  'jquery',
  'components/helper/base-helper',
  'components/helper/bs-datepicker-config',
  'components/helper/helper',
  'common/log/log',
  'common/db/db',
  'components/validate/jq-validate',
  'components/textarea/autosize-textarea'
], function (
  $,
  BaseHelper,
  datepickerConfig,
  helper, Logger, db,
  validator, autoTextArea) {
    helper.factory({
      type: 'bs-switch'
    }).then(function (switchHelper) {
      switchHelper.render('input[name="bsSwitch"]');
    });


    // 同步渲染datepicker
    BaseHelper(datepickerConfig).render('[name="datepicker"], .input-daterange input');
    // BaseHelper(datepickerConfig).render('.input-daterange input');
    // 异步渲染timepicker
    helper.factory({
      type: 'bs-timepicker'
    }).then(function (timerHelper) {
      timerHelper.render('input[data-role="timepicker"]');
    });


    // 使用logger
    logger = Logger.get('form');
    logger.info('12312312313');

    // 使用前端db暂存数据
    db.setItem('test', 'datepicker');

    helper.factory({
      type: 'icheck'
    }).then(function (checkHelper) {
      checkHelper.render('input[name="icheck"]');
    });
    helper.factory({
      type: 'bs-datetimepicker'
    }).then(function (datetimeHelper) {
      var selector = 'input[data-role="datetimepicker"]';
      var $dateTimePicker = datetimeHelper.render(selector);
      // $dateTimePicker.datetimepicker('show');
      datetimeHelper.callWith(selector, 'show');
      datetimeHelper.callWith(selector, 'viewMode', 'years');

    });

    autoTextArea.autosize('.form-group textarea, .form-group input');

  });

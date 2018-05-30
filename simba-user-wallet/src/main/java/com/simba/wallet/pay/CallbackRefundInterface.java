package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public interface CallbackRefundInterface {
    JsonResult startRefund();

    JsonResult finishRefund();
}

package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public interface CallbackRechargeInterface {
    JsonResult startRecharge();

    JsonResult finishRecharge();
}

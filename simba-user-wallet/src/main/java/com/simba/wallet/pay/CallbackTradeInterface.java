package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public interface CallbackTradeInterface {
    JsonResult startTrade();

    JsonResult finishTrade();
}

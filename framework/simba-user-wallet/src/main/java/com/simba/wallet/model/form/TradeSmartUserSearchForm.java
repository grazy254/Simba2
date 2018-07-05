package com.simba.wallet.model.form;

import com.simba.annotation.DBFieldAnnotation;

public class TradeSmartUserSearchForm {

    @DBFieldAnnotation(desc = "用户账户")
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}

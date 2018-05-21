package com.simba.wallet.util;

import java.text.DecimalFormat;

import com.simba.exception.BussException;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;

public class FmtUtil {
	public static String transToCNYType(Long amount) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return fmt.format(amount * 1.0 / 100) + "元";
	}

	public static String fmtTradeType(String tradeType) {
		if (TradeType.CONSUME.getName().equals(tradeType)) {
			return TradeType.CONSUME.getDesc();
		} else if (TradeType.RECHARGE.getName().equals(tradeType)) {
			return TradeType.RECHARGE.getDesc();
		} else {
			throw new BussException("不支持的交易类型");
		}
	}

	public static String fmtTradeStatus(String tradeStatus) {
		if (TradeStatus.FAILED.getName().equals(tradeStatus)) {
			return TradeStatus.FAILED.getDesc();
		} else if (TradeStatus.SUCCESS.getName().equals(tradeStatus)) {
			return TradeStatus.SUCCESS.getDesc();
		} else if (TradeStatus.OVERTIME.getName().equals(tradeStatus)) {
			return TradeStatus.OVERTIME.getDesc();
		} else if (TradeStatus.INPROCESS.getName().equals(tradeStatus)) {
			return TradeStatus.INPROCESS.getDesc();
		} else {
			throw new BussException("不支持的交易状态");
		}
	}

}

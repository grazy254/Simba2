package com.simba.wallet.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.relops.snowflake.Snowflake;
import com.simba.framework.util.common.UUIDUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.util.Constants.AccountActiveStatus;
import com.simba.wallet.util.Constants.AccountFrozenStatus;
import com.simba.wallet.util.Constants.AccountType;
import com.simba.wallet.util.Constants.TradePayment;
import com.simba.wallet.util.Constants.TradeRechargement;
import com.simba.wallet.util.Constants.TradeUserType;

public class CommonUtil {

	public static String transToCNYType(Long amount) {
		return transToCNYTypeWithouUnit(amount) + "元";
	}

	public static String transToCNYTypeWithouUnit(Long amount) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return fmt.format(amount * 1.0 / 100);
	}

	public static String transToCNYType(Long amount, boolean addMinus) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		if (addMinus) {
			amount = amount * -1;
		}
		return fmt.format(amount * 1.0 / 100);
	}

	public static Long CNYToLong(String amount) throws ParseException {
		DecimalFormat fmt = new DecimalFormat("0.00");
		return (long) (fmt.parse(amount).doubleValue() * 100);
	}

	public static AccountActiveStatus checkAccountActive(TradeAccount tradeAccount) {
		if (tradeAccount.getIsActive() == AccountActiveStatus.ACTIVE.getValue()) {
			return AccountActiveStatus.ACTIVE;
		} else if (tradeAccount.getIsActive() == AccountActiveStatus.CLOSED.getValue()) {
			return AccountActiveStatus.CLOSED;
		} else if (tradeAccount.getIsActive() == AccountActiveStatus.NOTACTIVE.getValue()) {
			return AccountActiveStatus.NOTACTIVE;
		} else {
			throw ErrConfig.INVALID_ACCOUNT_ACTIVE_TYPE;
		}
	}

	public static AccountFrozenStatus checkAccountFrozen(TradeAccount tradeAccount) {
		if (tradeAccount.getIsFrozen() == AccountFrozenStatus.FROZEN.getValue()) {
			return AccountFrozenStatus.FROZEN;
		} else if (tradeAccount.getIsFrozen() == AccountFrozenStatus.NOTFROZEN.getValue()) {
			return AccountFrozenStatus.NOTFROZEN;
		} else {
			throw ErrConfig.INVALID_ACCOUNT_FROZEN_TYPE;
		}
	}

	public static AccountActiveStatus checkTradeUserActive(TradeUser tradeUser) {
		if (tradeUser.getIsActive() == AccountActiveStatus.ACTIVE.getValue()) {
			return AccountActiveStatus.ACTIVE;
		} else if (tradeUser.getIsActive() == AccountActiveStatus.CLOSED.getValue()) {
			return AccountActiveStatus.CLOSED;
		} else if (tradeUser.getIsActive() == AccountActiveStatus.NOTACTIVE.getValue()) {
			return AccountActiveStatus.NOTACTIVE;
		} else {
			throw ErrConfig.INVALID_TRADEUSER_ACTIVE_TYPE;
		}
	}

	public static TradePayment checkTradeUserPayment(TradeUser tradeUser) {
		if (tradeUser.getIsAllowPay() == TradePayment.ALLOWPAY.getValue()) {
			return TradePayment.ALLOWPAY;
		} else if (tradeUser.getIsAllowPay() == TradePayment.NOTALLOWPAY.getValue()) {
			return TradePayment.NOTALLOWPAY;
		} else {
			throw ErrConfig.INVALID_TRADE_PAYMENT_TYPE;
		}
	}

	public static TradePayment checkAccountPayment(TradeAccount tradeAccount) {
		if (tradeAccount.getIsAllowPay() == TradePayment.ALLOWPAY.getValue()) {
			return TradePayment.ALLOWPAY;
		} else if (tradeAccount.getIsAllowPay() == TradePayment.NOTALLOWPAY.getValue()) {
			return TradePayment.NOTALLOWPAY;
		} else {
			throw ErrConfig.INVALID_TRADE_PAYMENT_TYPE;
		}
	}

	private static TradeRechargement checkAccountRechargement(TradeAccount tradeAccount) {
		if (tradeAccount.getIsAllowRecharge() == TradeRechargement.ALLOWRECHARGE.getValue()) {
			return TradeRechargement.ALLOWRECHARGE;
		} else if (tradeAccount.getIsAllowRecharge() == TradeRechargement.NOTALLOWRECHARGE.getValue()) {
			return TradeRechargement.NOTALLOWRECHARGE;
		} else {
			throw ErrConfig.INVALID_TRADE_RECHARGEMENT_TYPE;
		}
	}

	public static String getUserStatus(TradeUser tradeUser) {
		return checkTradeUserActive(tradeUser).getName();
	}

	public static String getAccountStatus(TradeAccount tradeAccount) {
		AccountActiveStatus activeStatus = checkAccountActive(tradeAccount);
		AccountFrozenStatus frozenStatus = checkAccountFrozen(tradeAccount);
		return (activeStatus == AccountActiveStatus.ACTIVE) ? frozenStatus.getName() : activeStatus.getName();
	}

	public static AccountType getAccountType(TradeUserType tradeUserType) {
		if (tradeUserType.equals(TradeUserType.PERSION)) {
			return AccountType.PERSIONAL_ACCOUNT;
		} else if (tradeUserType.equals(TradeUserType.DEPARTMENT)) {
			return AccountType.COMPANY_ACCOUNT;
		} else if (tradeUserType.equals(TradeUserType.CHANNEL)) {
			return AccountType.CHANNEL_ACCOUNT;
		} else {
			throw ErrConfig.INVALID_TRADEUSER_TYPE;
		}
	}

	public static AccountType getAccountType(String accountType) {
		if (AccountType.CHANNEL_ACCOUNT.getValue().equals(accountType)) {
			return AccountType.CHANNEL_ACCOUNT;
		} else if (AccountType.COMPANY_ACCOUNT.getValue().equals(accountType)) {
			return AccountType.COMPANY_ACCOUNT;
		} else if (AccountType.PERSIONAL_ACCOUNT.getValue().equals(accountType)) {
			return AccountType.PERSIONAL_ACCOUNT;
		} else {
			throw ErrConfig.INVALID_ACCOUNT_TYPE;
		}

	}

	public static Map<String, String> fmtBalance(Map<String, Object> balanceMap) {
		Map<String, String> map = new HashMap<String, String>();
		if (balanceMap.get("accountBalance") != null) {
			map.put("accountBalance", CommonUtil.transToCNYType(Long.parseLong(balanceMap.get("accountBalance").toString())));
		}
		if (balanceMap.get("availableBalance") != null) {
			map.put("availableBalance", CommonUtil.transToCNYType(Long.parseLong(balanceMap.get("availableBalance").toString())));
		}
		if (balanceMap.get("virtualBalance") != null) {
			map.put("virtualBalance", CommonUtil.transToCNYType(Long.parseLong(balanceMap.get("virtualBalance").toString())));
		}
		if (balanceMap.get("frozenBalance") != null) {
			map.put("frozenBalance", CommonUtil.transToCNYType(Long.parseLong(balanceMap.get("frozenBalance").toString())));
		}
		return map;
	}

	public static class TradeNoGenerator {
		public static Snowflake snowflake = null;

		public static long gen(Integer nodeId) {
			if (snowflake == null) {
				synchronized (TradeNoGenerator.class) {
					if (snowflake == null) {
						snowflake = new Snowflake(nodeId);
					}
				}
			}
			return snowflake.next();
		}
	}

	public static long generateTradeNO() {
		return 1L;
	}

	public static String generateOrderNO() {
		return "r" + UUIDUtil.get();
	}

	public static void checkWalletAutority(TradeUser tradeUser, TradeAccount tradeAccount, TradeUserType tradeUserType) {
		if (checkAccountActive(tradeAccount) != AccountActiveStatus.ACTIVE || checkTradeUserActive(tradeUser) != AccountActiveStatus.ACTIVE) {
			if (tradeUserType == TradeUserType.PERSION) {
				throw ErrConfig.INVALID_WALLET_USER;
			} else {
				throw ErrConfig.WALLET_UNAVAILABLE;
			}
		}

		if (checkAccountFrozen(tradeAccount) == AccountFrozenStatus.FROZEN) {
			if (tradeUserType == TradeUserType.PERSION) {
				throw ErrConfig.WALLET_FROZEN;
			} else {
				throw ErrConfig.WALLET_UNAVAILABLE;
			}
		}

		if (tradeUserType == TradeUserType.PERSION) {
			if (checkTradeUserPayment(tradeUser) == TradePayment.NOTALLOWPAY || checkAccountPayment(tradeAccount) == TradePayment.NOTALLOWPAY) {
				throw ErrConfig.WALLET_NOT_ALLOWPAY;
			}
			if (checkAccountRechargement(tradeAccount) == TradeRechargement.NOTALLOWRECHARGE) {
				{
					throw ErrConfig.WALLET_NOT_ALLOWRECHARGE;
				}
			}
		}
	}

	public static Date getGmtDate(String gmtDate) {
		if (gmtDate == null) {
			return DateUtil.str2Date("1979-01-01", DateUtil.DAY_FORMAT, new Date());
		}
		Date date = null;
		try {
			date = DateUtil.str2Date(gmtDate, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			date = DateUtil.str2Date(gmtDate, "yyyyMMddHHmmss");
		}
		return date;
	}

}

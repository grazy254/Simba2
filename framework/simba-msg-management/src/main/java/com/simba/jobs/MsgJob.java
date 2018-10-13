package com.simba.jobs;

import static com.simba.util.DayAmountUtil.DAY_AMOUNT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.model.DayAmount;
import com.simba.service.DayAmountService;
import com.simba.util.DayAmountUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

/**
 * 短信统计的定时任务
 * 
 * @author caozhejun
 *
 */
@Component
@Transactional
public class MsgJob {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private DayAmountService dayAmountService;

	@Autowired
	private DayAmountUtil dayAmountUtil;

	/**
	 * 每天的1点执行, 保存当天的用量, 并将计数器清零
	 *
	 * @return
	 */
	@Scheduled(cron = "0 0 1 * * ?")
	public void countDayMsg() {
		boolean isLock = redisUtil.tryLock(DayAmountUtil.TIMERLOCK_REDIS_KEY, 60);
		if (isLock) {
			count();
		}
	}

	private void count() {
		try (Jedis jedis = redisUtil.getJedis()) {
			int cursor = -1;
			long timeout = System.currentTimeMillis() + 1000 * 60;
			while (cursor != 0) {
				if (cursor == -1) {
					cursor = 0;
				}
				ScanResult<Map.Entry<String, String>> result = jedis.hscan(DAY_AMOUNT, Integer.toString(cursor));
				cursor = Integer.parseInt(result.getStringCursor());
				for (Map.Entry<String, String> m : result.getResult()) {
					DayAmount newDayAmount = new DayAmount();
					newDayAmount.setAmount(Integer.parseInt(m.getValue()));
					newDayAmount.setDayDate(getYesterday(DateUtil.getTime()));
					newDayAmount.setProjectId(Integer.parseInt(m.getKey()));
					dayAmountService.add(newDayAmount);
				}
				if (System.currentTimeMillis() > timeout) {
					throw new RuntimeException("超时");
				}
			}
			// 清0
			dayAmountUtil.clean();
		}
		redisUtil.releaseLock(DayAmountUtil.TIMERLOCK_REDIS_KEY);
	}

	/**
	 * 获取前一天
	 *
	 * @param day
	 * @return
	 */
	private Date getYesterday(Date day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}
}

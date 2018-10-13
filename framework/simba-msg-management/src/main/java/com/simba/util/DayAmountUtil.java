package com.simba.util;

import com.simba.cache.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by shuoGG on 2018/7/20
 */
@Component
public class DayAmountUtil {

	@Autowired
	private RedisUtil redisUtil;

	public static final String DAY_AMOUNT = "msgDayAmount";
	public static final String TIMERLOCK_REDIS_KEY = "shortMessageTimerLock";

	public void clean() {
		redisUtil.remove(DAY_AMOUNT);
	}

	public void setAmount(String projectId, int value) {
		clean();
		incrAmount(projectId, value);
	}

	public Integer getAmount(String projectId) {
		try (Jedis jedis = redisUtil.getJedis()) {
			return Integer.valueOf(jedis.hget(DAY_AMOUNT, projectId));
		} catch (Exception e) {
			clean();
		}
		return 0;
	}

	/**
	 * 原子自增
	 *
	 * @param projectId
	 * @param value
	 */
	public void incrAmount(String projectId, int value) {
		try (Jedis jedis = redisUtil.getJedis()) {
			jedis.hincrBy(DAY_AMOUNT, projectId, value);
		} catch (Exception e) {
			clean();
		}
	}

}

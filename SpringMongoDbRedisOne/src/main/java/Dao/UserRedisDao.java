package Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class UserRedisDao {
	
	@Autowired 
	private RedisTemplate< String, Object > r_1_5;
	
	
	public void setR_1_5(RedisTemplate<String, Object> r_1_5) {
		this.r_1_5 = r_1_5;
	}

	public String redisGet() {
		
		String str=(String)r_1_5.opsForHash().get("1","a1");
		return str;
		
	}
	
	

}

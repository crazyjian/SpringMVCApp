package com.jerry.myapp.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @deprecated 静态注入中间类  
 * @author Administrator
 *
 */
public class RedisCacheTransfer {
	
	@Autowired  
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {  
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);  
    }  

}

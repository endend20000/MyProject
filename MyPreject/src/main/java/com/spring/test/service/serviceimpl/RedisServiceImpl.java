package com.spring.test.service.serviceimpl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.test.service.RedisService;
import com.spring.tools.redis.JedisCache;
import org.springframework.data.mongodb.core.*;

@Service
public class RedisServiceImpl implements RedisService{
	
	@Resource
	private JedisCache  jedisCache;
	
	 @Override
	  public void testSetAndGetRedis(){
		  String uuid  =  UUID.randomUUID().toString(); 
  
		  jedisCache.set(uuid, "大姨妈");
		  jedisCache.expire(uuid, 100000);
		  
		  String out=jedisCache.get(uuid);
		  System.out.println(out);
	  }
}

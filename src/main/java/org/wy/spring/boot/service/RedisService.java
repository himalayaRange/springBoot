package org.wy.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.wy.spring.boot.model.Address;
import org.wy.spring.boot.model.User;
/** 查看多有的keys命令： keys *  */
@Service
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Cacheable(value = "usercache" , keyGenerator = "wiselyKeyGenerator")
	public User findUser(Long id , String firstName , String lastName){
		System.out.println("无缓存调用：findUser");
		
		return new User(id, firstName, lastName);
	}

	@Cacheable(value = "addresscache" , keyGenerator = "wiselyKeyGenerator")
	public Address findAddress(Long id , String province , String city){
		System.out.println("无缓存调用：findAddress");
		
		return new Address(id, province, city);
	}
	
	public void operationReids(){
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("myKey", "random="+Math.random());
		System.err.println(opsForValue.get("myKey"));
	}
	
}

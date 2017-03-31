package org.wy.spring.boot.redis;

import java.lang.reflect.Method;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.wy.spring.boot.constants.Constant;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

	/**
	 * 重新定义Redis Key 生成策略
	 * @return
	 */
	@Bean
	public KeyGenerator wiselyKeyGenerator(){
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for(Object obj : params){
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
	
	/**
	 * 缓存管理器
	 * @param redisTemplate
	 * @return
	 *
	 */
	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes")RedisTemplate redisTemplate){
		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
		if(!Constant.expire_off){
			rcm.setDefaultExpiration(Constant.defaultExpiration); //失效时间
		}
		return rcm;
	}
	
	/**
	 * redis 模板操作类
	 * @param factory 通过spring注入，参数在application.properties中配置
	 * @return 
	 *
	 */
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		ObjectMapper om = new ObjectMapper();  
		om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setValueSerializer(jackson2JsonRedisSerializer);
       /* template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);*/
        template.afterPropertiesSet();  
        return template;
	}
	
}

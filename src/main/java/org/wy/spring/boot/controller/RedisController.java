package org.wy.spring.boot.controller;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wy.spring.boot.model.Address;
import org.wy.spring.boot.model.User;
import org.wy.spring.boot.service.RedisService;
/**
 * Redis 集成到 Spring Boot 中
 * Created by WangYi on 2017-3-21.
 */

@Controller
public class RedisController {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value = "/putCache")
	@ResponseBody
	public String putCache(){
		redisService.findUser(1L, "wang", "yi");
		redisService.findAddress(1L, "安徽", "合肥");
		
		return "put cache to redis ok";
	}
	
	@RequestMapping(value = "/getCache")
	@ResponseBody
	public String getCache(){
		User user = redisService.findUser(1L, "wang", "yi");
		Address address = redisService.findAddress(1L, "安徽", "合肥");
		System.err.println("这里没执行查询语句....");
		System.out.println(user.toString());
		System.out.println(address.toString());
		return "get cache from redis ok";
	}
	
	@RequestMapping(value="/test")
	public @ResponseBody void test(HttpServletRequest request){
		redisService.operationReids();
	}
	
	/**
	 * 分布式缓存管理Session
	 * 当spring-session和redis集成后，原servlet中的session即失效，由redis进行托管
	 * @param session
	 * @return
	 *
	 */
	@RequestMapping(value = "/uid")
	public String uid(HttpSession session){
		UUID uid = (UUID)session.getAttribute("uid");
		if(uid == null){
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		
		return session.getId();
	}
}

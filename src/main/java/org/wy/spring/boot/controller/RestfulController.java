package org.wy.spring.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 发布restfull风格API
 * Created by WangYi on 2017-3-28.
 */
@RestController
public class RestfulController {

	@RequestMapping(value = "/users/{username}" , method = RequestMethod.GET , produces = "application/json; charset=utf-8")
	public String getUser(@PathVariable String username){
		
		return "welocome:"+username;
	}
	
}

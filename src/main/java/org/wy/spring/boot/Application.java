package org.wy.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.wy.spring.boot.constants.Constant;
/**
 * 项目作为依赖Jar运行
 * Created by WangYi on 2017-3-20.
 */
@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = Constant.scan_mapper_package)
public class Application extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	public String home(){
		return "redirect:countries";
	}
}

package org.wy.spring.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wy.spring.boot.model.City;
import org.wy.spring.boot.service.CityService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@RequestMapping
	public PageInfo<City> getAll(City city){
		List<City> cityList = cityService.getAll(city);
		return new PageInfo<City>(cityList);
	}
	
	@RequestMapping(value="/add")
	public City add(){
		return new City();
	}
	
	 @RequestMapping(value = "/view/{id}")
	    public City view(@PathVariable Integer id) {
	        City city = cityService.getById(id);
	        return city;
	    }

	    @RequestMapping(value = "/delete/{id}")
	    public ModelMap delete(@PathVariable Integer id) {
	        ModelMap result = new ModelMap();
	        cityService.deleteById(id);
	        result.put("msg", "删除成功!");
	        return result;
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelMap save(City city) {
	        ModelMap result = new ModelMap();
	        String msg = city.getId() == null ? "新增成功!" : "更新成功!";
	        cityService.save(city);
	        result.put("city", city);
	        result.put("msg", msg);
	        return result;
	    }
}

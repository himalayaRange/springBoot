package org.wy.spring.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wy.spring.boot.mapper.CityMapper;
import org.wy.spring.boot.model.City;
import com.github.pagehelper.PageHelper;

@Service
public class CityService {
	@Autowired
	private CityMapper cityMapper;
	
	public List<City> getAll(City city){
		if(city.getPage() != null && city.getRows() != null){
			PageHelper.startPage(city.getPage(), city.getRows());
		}
		return cityMapper.selectAll();
	}
	
	public City getById(Integer id){
		return cityMapper.selectByPrimaryKey(id);
	}
	
	public void deleteById(Integer id){
		cityMapper.deleteByPrimaryKey(id);
	}
	
	public void save(City city){
		if(city.getId() != null){
			cityMapper.updateByPrimaryKeySelective(city);
		}else{
			cityMapper.insertSelective(city);
		}
	}
}

package org.wy.spring.boot.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * 继承自己的Mapper（封装了常用的CRUD方法和对应的映射文件，映射文件中只需要添加复杂的SQL映射文件）
 * 该接口不能被扫描到，否则会报错
 * Created by WangYi on 2017-3-16.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
	
}

package org.wy.spring.boot.constants;

public interface Constant {
	/** 扫描实体的包路径 */
	public static final String scan_model_package = "org.wy.spring.boot.model";
	/** 映射文件的路径 */
	public static final String mapper＿locations = "classpath:mapper/*.xml";
	/** 扫描接口Mapper的包路径 */
	public static final String scan_mapper_package = "org.wy.spring.boot.mapper";
	
	/** Redis是否设置缓存失效时间 */
	public static final boolean expire_off = false ; 		// false表示开启失效时间，true关闭失效时间
	public static final long defaultExpiration = 1800 ;		// 秒，expire_off 需要设置成false
}

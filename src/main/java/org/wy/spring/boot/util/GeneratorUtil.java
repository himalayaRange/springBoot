package org.wy.spring.boot.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 可以通过Maven命令mybatis-generator:generate生成、
 * 参考：http://mbg.cndocs.tk/running/running.html
 * Created by WanggYi on 2017-3-20.
 */
public class GeneratorUtil {
	
	/*public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		generatorConfig();
	}*/
	
	public static void generatorConfig()throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
		List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("src/main/resources/generator/generatorConfig.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);	
	}
}

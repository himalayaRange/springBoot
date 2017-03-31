配置文件：
	修改Constant中的相关配置
	修改application.properties相关的配置

本地启动：
	1.spring boot对配置文件进行了简化，只需要application.properties中进行相关的配置即可
	2.启动类：Application.class,访问http://localhost:9090/

本地热部署: mvn spring-boot:run


发布：

1.将项目发布成war,依赖的文件pom-war.xml和WarApplication.class和Application.class
  pom-war.xml是将项目作为web项目，直接打包 mvn clear package即可转化成普通的web项目

2.将项目作为一个单独的可运行jar，依赖的文件pom.xml和Application.class
     直接打包 mvn package生成jar放在服务器上的合适位置，通过命令 java -jar xxx.jar
    如果想关闭spring Boot进程 ps aux|grep spring|xargs kill -9
       
*********************************************************************************************
							spring boot + redis				
*********************************************************************************************
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-redis</artifactId>
    <version>1.4.1.RELEASE</version>
</dependency>


http请求调试工具 postman，安装参考http://blog.csdn.net/u010246789/article/details/51481134

    
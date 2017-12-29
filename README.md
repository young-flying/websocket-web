该项目为spring boot 集成mybatis

坑：
1.引入mybatis-spring-boot-starter jar包时要注意版本号
我是用的是1.3以上的版本，该版本要匹配spring Boot1.5 or higher ,我用的是spring Boot1.4，这个坑了我好久
启动就是加载不了mybatis配置 
error: Cannot load configuration class: org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration

2.mybatis generator 
2.1 在pom文件中集成mybatis generator 插件
<plugins>
	      	<!-- MyBatis代码生成 -->
	         <plugin>  
	             <groupId>org.mybatis.generator</groupId>  
	             <artifactId>mybatis-generator-maven-plugin</artifactId>  
	             <version>1.3.2</version>  
	             <configuration>  
	                 <verbose>true</verbose>  
	                 <overwrite>true</overwrite>  
	                 <configurationFile>src_config/generatorConfig.xml</configurationFile>  
	             </configuration>  
	         </plugin> 
<plugins>
2.2 为了区分默认的文件配置加了资源文件夹
<resources>  
   <!-- 配置多个资源文件夹 -->
   <resource>  
      <directory>src_config</directory>  
   </resource>  
</resources> 
2.3 在 src_config添加generatorConfig数据库相关信息配置文件  generatorConfig.properties
生成mapper的配置信息文件generatorConfig.xml
这个一看就懂，移动就会用，其中一定要引入数据库驱动jar包
2.4 执行 工程右键 Debug As -> maven build... -> mybatis-generator:generate

3.junit 创建测试类的时候在默认test目录下 结果老是报错 
解决方案 src/test/java 下的包名要和src/main/java/下的包名相同

http://blog.csdn.net/g960806/article/details/78443691

启动：
启动类 ：org.jewi.work下的Application



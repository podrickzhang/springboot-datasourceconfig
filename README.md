# springboot-datasourceconfig
springboot+mybatis的搭建，mybatis逆向工程，druid数据源配置

## MyBatis逆向工程
MyBatis的一个主要的特点就是需要程序员自己编写sql，那么如果表太多的话，难免会很麻烦，所以mybatis官方提供了一个逆向工程，可以针对单表自动生成mybatis执行所需要的代码（包括mapper.xml、mapper.java、po..）。一般在开发中，常用的逆向工程方式是通过数据库的表生成代码。

### 步骤
- 根据sql中的文件导入到数据库中，这里是以Intellij IDEA为例<br>
在pom.xml中配置插件
```
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.2</version>
                <configuration>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
            </plugin>
        </plugins>
    </build>

```
- 在application.yml文件中配置数据源
```
spring:
  datasource:
    url: jdbc:mysql://lcoalhost:3306/o2o?useUnicode=true&characterEncoding=utf-8
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
```
- 在resources文件夹下创建generatorConfig.xml文件。（用于生成逆向工程的文件）。
- 然后使用maven配置生成代码。（这里需要使用maven的命令行）。 
命令行是mybatis-generator:generate -e 
在IntelliJ IDEA中的操作步骤如下： 
首先选择Run->Edit Configurations.. 
然后点击左上角的“+”号，选择Maven 
最后在Working directory中填入你项目的根目录，然后在下面的Command line中填入mybatis-generator:generate -e。点击OK即可。 
然后运行，就可以生成代码了。<br>

---

## MyBatis的配置
本文没有采用mybatis-config.xml的配置方式，而是通过Java代码来进行的配置。在文件夹`com.rosam.springbootdatasourceconfig.databaseconfig`下，关于这几个配置类的注解可以查看我的csdn博客，[SpringBoot常用注解](https://blog.csdn.net/weixin_38070406/article/details/82897782)
<br>
在application.yml文件中添加mybatis的配置
```
mybatis:
  type-aliases-package: com.rosam.springbootdatasourceconfig.entity
  mapper-locations: classpath:mapper/*.xml
```
 typeAliases节点主要用来设置别名，其实这是挺好用的一个功能， 通过配置别名，我们不用再指定完整的包名，并且还能取别名。这里是配置了别名的实体类目录。例如： 我们在使用 com.demo.entity. UserEntity 的时候，我们可以直接配置一个别名user, 这样以后在配置文件中要使用到com.demo.entity. UserEntity的时候，直接使用user即可。
 
 ### Springboot定时任务@Scheduled
 在com.rosam.springbootdatasourceconfig.task中有两个文件，如果没有ScheduleConfig.java，那么运行的是单线程版的定时任务。有了就是多线程版的定时，配置了线程池，初始了5条线程。具体大家可以参考我的csdn博客，[springboot定时任务@Scheduled](https://blog.csdn.net/weixin_38070406/article/details/82912304)

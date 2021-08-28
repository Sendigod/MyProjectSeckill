

## 一、pom.xml文件配置

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.iamycx</groupId>
  <artifactId>seckill</artifactId>
  <packaging>war</packaging>
  <version>1.0.0</version>
  <name>seckill Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <!--补全项目依赖-->
    <!--1：日志 java日志：slf4j，log4j，logback，common-logging
        slf4j是规范、接口
        日志实现：log4j，logback，common-logging
        使用：slf4j+logback
    -->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.12</version>
    </dependency>
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-core</artifactId>
      <version>1.1.1</version>
    </dependency>
    <!--实现slf4j接口并整合 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.1</version>
    </dependency>
    <!--2.数据库相关依赖 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.35</version>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>c3p0</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.1.1</version>
    </dependency>
    <!-- DAO框架 Mybatis依赖 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.3.0</version>
    </dependency>
    <!--mybatis自身实现的spring整合依赖 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.2.3</version>
    </dependency>
    <!--3. Servlet Web相关依赖 -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>
    <!--4. Spring依赖 -->
    <!--1)spring核心依赖 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!--2)spring dao层依赖 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!--3)springWeb相关依赖 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!--4)spring test相关依赖 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>

    <!--添加redis依赖 -->
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
      <version>2.7.3</version>
    </dependency>

    <!--prostuff序列化依赖 -->
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-core</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-runtime</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
      <version>3.2</version>
    </dependency>
    <!--redis客户端 Jedis-->
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
      <version>2.7.3</version>
    </dependency>
    <!--protostuff序列化依赖-->
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-core</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-runtime</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
      <version>3.2</version>
    </dependency>
  </dependencies>
  <build>
    <finalName>seckill</finalName>
  </build>
</project>
```



## 二、把目录建好

大体是这样子，后面再加。

main---java

​		---resources

​		---sql

​		---webapp

test---java



## 三、建立数据库表

1、先建库seckill

2、建表seckill和success_killed

建表sql：

```sql
-- 创建数据库
CREATE database seckill;

-- 使用数据库
use seckill;

-- 创建秒杀库存表seckill
CREATE TABLE seckill
(
    `seckill_id`  bigint       NOT NULL AUTO_INCREMENT comment '商品库存id',
    `name`        varchar(120) NOT NULL COMMENT '商品名称',
    `number`      int          NOT NULL COMMENT '库存数量',
    `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `start_time`  TIMESTAMP    NOT NULL COMMENT '秒杀创建时间',
    `end_time`    TIMESTAMP    NOT NULL COMMENT '秒杀结束时间',
    primary key (seckill_id),
    KEY idx_start_time (start_time),
    KEY idx_end_time (end_time),
    KEY idx_create_time (create_time)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT  CHARSET =utf8 comment ='秒杀库存表';

-- 初始化数据
INSERT INTO seckill(name, number, start_time, end_time)
values
('十块钱秒杀汤臣一品',100,'2021-08-04 00:00:00','2021-08-06 00:00:00'),
('十块钱秒杀华为P50',10,'2021-08-05 00:00:00','2021-08-06 00:00:00'),
('十块钱秒杀奥运会奖牌一枚',500,'2021-08-06 00:00:00','2021-08-09 00:00:00'),
('十块钱秒杀美女李彩娇',5,'2021-08-06 00:00:00','2022-08-06 00:00:00');

-- 秒杀成功明细表success_killed
CREATE TABLE success_killed(
    `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
    `user_phone` BIGINT NOT NULL COMMENT '用户手机号码',
    `state` INT NOT NULL DEFAULT -1 COMMENT '状态标志：-1：无效 0：成功 1：已付款 2：已发货',
    `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
    primary key (seckill_id),/*联合主键*/
    KEY idx_create_time(create_time)
)ENGINE =InnoDB DEFAULT CHARSET =utf8 COMMENT ='秒杀成功明细表';
```



## 四、开始敲代码

包												对应放什么类

service										接口类（业务逻辑）

​		--serviceImpl   				  接口实现类

dao											 数据库交互

dto											  数据传输

entity										  实体类

web											 controller

enums										枚举类

exception								   异常处理

###1、根据数据库写实体类代码。

seckill

```java
package com.sorrymaker.seckill.entity;

import java.util.Date;

/**
 * @Author nextGame
 * @Date 2021/8/3 21:55
 * @Version 1.0
 */
public class Seckill {

    private long seckillId;

    private String name;

    private int number;

    private Date startTime;

    private Date endTime;

    private Date createTime;


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "seckill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}

```

SuccessedKilled

```java
package com.sorrymaker.seckill.entity;

import java.util.Date;

/**
 * @Author nextGame
 * @Date 2021/8/3 21:59
 * @Version 1.0
 */
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private  short state;

    private Date createTime;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //一个秒杀商品，对应多个秒杀成功记录，所有需要多对一。需要把这个类引用进来。
    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }


}
```

### 2、dao代码

seckillDao

```java
package com.sorrymaker.seckill.dao;

import com.sorrymaker.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @Author nextGame
 * @Date 2021/8/4 19:49
 * @Version 1.0
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1 表示更新的记录行数
     */
    int reduceCount(long seckillId, Date killTime);

    /**
     * 根据seckillId查询商品
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量和限制查询商品列表。
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offset, int limit);


}
```

SuccessedKilledDao

```java
package com.sorrymaker.seckill.dao;

import com.sorrymaker.seckill.entity.Seckill;
import com.sorrymaker.seckill.entity.SuccessKilled;

import java.util.Date;

/**
 * @Author nextGame
 * @Date 2021/8/4 21:22
 * @Version 1.0
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可以过滤掉重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数， 返回0 插入失败
     */
    int insertSuccessKilled(long seckillId,int userPhone);


    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId,int userPhone);
}
```

## 五、Mybatis相关工作

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

    <!-- 全局配置-->
    <settings>

        <!--使用jdbc的getGeneratedkeys获取数据库自增主键值 -->
        <setting name="useGeneratedKeys" value="true"/>

        <!--开启驼峰命名转换Table:create_time到 Entity(createTime)-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>

        <!--使用列别名替换别名，默认是true -->
        <setting name="useColumnLabel" value="true"/>

    </settings>
</configuration>
```



创建一个目录，放mybatis 的sql的映射mapper。      

### 1、写SeckillDao.xml                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-mapper.dtd"><!-- namespace命名空间,作用就是对sql进行分类化管理,理解sql隔离注意:使用mapper代理方法开发,namespace有特殊重要的作用,namespace等于mapper接口地址--><mapper namespace="sorrymaker.seckill.dao.SeckillDao">    <!--目的：为Dao接口方法提供sql语句配置 -->    <update id="reduceCount">        <!-- 具体sql语句  <![CDATA[??]]告诉sql，？？是我们需要用的，不是他们的语法。关键字冲突了。-->        UPDATE seckill        set number = number - 1        where seckill_id = #{seckillId}        AND start_time <![CDATA[ <= ]]> #{killTime}        AND end_time >= #{killTime}        AND number > 0;    </update>    <select id="queryById" resultType="Seckill" parameterType="long">        SELECT seckill_id,name,number,start_time,end_time,create_time        FROM  seckill        WHERE seckill_id = #{seckillId}    </select>    <select id="queryAll" resultType="Seckill" parameterType="int">        SELECT seckill_id,name,number,start_time,end_time,create_time        SELECT seckill_id,name,number,start_time,end_time,create_time        FROM seckill        ORDER BY create_time DESC        limit ${offset},#{limit}    </select></mapper>
```

### 2、SuccessKilledDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?><!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"        "http://mybatis.org/dtd/mybatis-3-mapper.dtd"><!-- namespace命名空间,作用就是对sql进行分类化管理,理解sql隔离注意:使用mapper代理方法开发,namespace有特殊重要的作用,namespace等于mapper接口地址--><mapper namespace="sorrymaker.seckill.dao.SuccessKilledDao">    <insert id ="insertSuccessKilled">        <!-- 主键冲突，报错 -->        <!-- 这里加个ignore，就可以在冲突的时候，返回0行，就是解决重复问题-->        insert ignore into success_killed(seckill_id,user_phone,state)        value (#{seckillId},#{userPhone},0)    </insert>    <select id="queryByIdWithSeckill" resultType="SuccessKilled">        <!--根据id查询SuccessKilled并携带Seckill实体 -->        <!--可以自动控制SQL语句 -->        select            sk.seckill_id,            sk.user_phone,            sk.create_time,            sk.state,            s.seckill_id "seckill.seckill_id",            s.name "seckill.name",            s.number "seckill.number",            s.start_time "seckill.start_time",            s.end_time "seckill.end_time",            s.create_time "seckill.create_time"        from success_killed sk        inner join seckill s on sk.seckill_id = s.seckill_id        where sk.seckill_id = #{seckillId} and sk.user_phone=#{userPhone}    </select></mapper>
```

### 3、Mybatis的Spring相关配置                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

```xml
<?xml version="1.0" encoding="UTF-8"?><beans xmlns="http://www.springframework.org/schema/beans"       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       xmlns:util="http://www.springframework.org/schema/util"       xmlns:context="http://www.springframework.org/schema/context"       xsi:schemaLocation="http://www.springframework.org/schema/beans        http://www.springframework.org/schema/beans/spring-beans.xsd        http://www.springframework.org/schema/util        http://www.springframework.org/schema/util/spring-util-4.2.xsd">    <!--1.配置整合mybatis过程-->    <util:properties id="jdbc" location="classpath:jdbc.properties"/>    <!--2.数据库连接池 -->    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">        <!--配置连接池属性 -->        <property name="driverClass" value="#{jdbc['mysql.driver']}"/>        <property name="jdbcUrl" value="#{jdbc['jdbc.url']}"/>        <property name="user" value="#{jdbc['jdbc.username']}"/>        <property name="password" value="#{jdbc['jdbc.password']}"/>        <!--这里可以根据业务情况调整 -->        <!-- c3p0 连接池的私有属性 -->        <property name="maxPoolSize" value="30"/>        <property name="minPoolSize" value="10"/>        <!--关闭连接后不自动commit -->        <property name="autoCommitOnClose" value="false"/>        <!--获取连接超时时间 -->        <property name="checkoutTimeout" value="10000"/>        <!--获取连接重试次数 -->        <property name="acquireRetryAttempts" value="3"/>    </bean>    <!--3:配置SqlSessionFactory 对象 -->    <bean id ="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">        <!--注入数据库连接池 -->        <property name="dataSource" ref="dataSource"/>        <!--配置mybatis全局配置文件 ： mybatis-config.xml -->        <property name="configLocation" value="classpath:mybatis-config.xml"/>        <!--扫描entity包，使用别名，多个用;隔开-->        <property name="typeAliasesPackage" value="sorrymaker.seckill.entity"/>        <!--扫描sql配置文件，mapper需要的xml文件-->        <property name="mapperLocations" value="classpath:mapper/*.xml"/>    </bean>    <!--4:配置扫描dao接口包,动态实现Dao接口，并注入到spring容器中-->    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">        <!-- 注入sqlSessionFactory-->        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>        <!-- 给出扫描Dao接口包-->        <property name="basePackage" value="org.seckill.dao"/>    </bean></beans>
```

​          

## 六、编写dao的单元测试

测试刚刚写的代码有没有啥奇奇怪怪的bug。

1配置spring和junit整合，junit启动时加载springIOC容器。

```xml
@RunWith(SpringJUnit4ClassRunner.class)@ContextConfiguration({"classpath:spring/spring-dao.xml"})
```

2.编写单元测试。

```java
package com.sorrymaker.seckill.dao;import com.sorrymaker.seckill.entity.Seckill;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.test.context.ContextConfiguration;import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;import javax.annotation.Resource;import java.util.Date;import java.util.List;import static org.junit.Assert.*;/** * 配置spring和junit整合，junit启动时加载springIOC容器。 * @Author nextGame * @Date 2021/8/7 16:01 * @Version 1.0 */@RunWith(SpringJUnit4ClassRunner.class)@ContextConfiguration({"classpath:spring/spring-dao.xml"})public class SeckillDaoTest {    //注入dao实现类依赖    @Resource    private SeckillDao seckillDao;    @Test    public void reduceCount() {        Date killTime = new Date();        int count = seckillDao.reduceCount(1000, killTime);        System.out.println(count);    }    @Test    public void queryById() {        long id = 1000;        Seckill seckill = seckillDao.queryById(id);        System.out.println(seckill.getName());        System.out.println(seckill);    }    @Test    public void queryAll() {        //java没有保存形参的记录：queryAll(int offset,int limit) 不能传过来，要加注解@Param。        List<Seckill> seckills = seckillDao.queryAll(0, 100);        for(Seckill seckill:seckills){            System.out.println(seckill);        }    }}
```

```java
package com.sorrymaker.seckill.dao;import com.sorrymaker.seckill.entity.SuccessKilled;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.test.context.ContextConfiguration;import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;import javax.annotation.Resource;import static org.junit.Assert.*;/** * @Author nextGame * @Date 2021/8/8 13:49 * @Version 1.0 */@RunWith(SpringJUnit4ClassRunner.class)@ContextConfiguration({"classpath:spring/spring-dao.xml"})public class SuccessKilledDaoTest {    //注入dao实现类依赖    @Resource    private SuccessKilledDao successKilledDao;    @Test    public void insertSuccessKilled() {        long seckillId= 1001L;        long  userPhone= 15338202018L;        int count = successKilledDao.insertSuccessKilled(seckillId, userPhone);        System.out.println(count);    }    @Test    public void queryByIdWithSeckill() {        long seckillId= 1001L;        long  userPhone= 15338202018L;        SuccessKilled seckilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);        System.out.println(seckilled.getSeckillId());        System.out.println(seckilled.getSeckill().getName());    }}
```

## 提示：DAO拼接逻辑在Service层完成。

## 七、Service接口设计

### 1、秒杀的相关异常类

```java
package com.sorrymaker.seckill.exception;/** * 重复秒杀异常（运行期异常） * @Author nextGame * @Date 2021/8/8 16:57 * @Version 1.0 */public class RepeatKillException extends SeckillException {    public RepeatKillException(String message) {        super(message);    }    public RepeatKillException(String message, Throwable cause) {        super(message, cause);    }}
```

```java
package com.sorrymaker.seckill.exception;/** * 秒杀相关异常 * @Author nextGame * @Date 2021/8/8 16:59 * @Version 1.0 */public class SeckillException extends RuntimeException {    public SeckillException(String message) {        super(message);    }    public SeckillException(String message, Throwable cause) {        super(message, cause);    }}
```

```java
package com.sorrymaker.seckill.exception;/** * 秒杀关闭异常 * @Author nextGame * @Date 2021/8/8 16:58 * @Version 1.0 */public class SeckillCloseException extends SeckillException{    public SeckillCloseException(String message) {        super(message);    }    public SeckillCloseException(String message, Throwable cause) {        super(message, cause);    }}
```

### 2、枚举类

```java
package com.sorrymaker.seckill.enums;/** * 枚举表示常量 * @Author nextGame * @Date 2021/8/9 20:06 * @Version 1.0 */public enum SeckillStatEnum {    SUCCESS(1,"秒杀成功"),    END(0,"秒杀结束"),    REPEAT_KILL(-1,"重复秒杀"),    INNER_ERROR(-2,"系统异常"),    DATA_REWRITE(-3,"数据篡改");    private int state;    private String stateInfo;    SeckillStatEnum(int state, String stateInfo) {        this.state = state;        this.stateInfo = stateInfo;    }    public int getState() {        return state;    }    public String getStateInfo() {        return stateInfo;    }    public static SeckillStatEnum stateOf(int index){        for(SeckillStatEnum state:values()){            if(state.getState() == index){                return state;            }        }        return null;    }}
```

### 3、DTO包下的类设计（数据传递）

####暴露秒杀地址类Exposer

```java
package com.sorrymaker.seckill.dto;/** * 暴露秒杀地址DTO * @Author nextGame * @Date 2021/8/8 16:49 * @Version 1.0 */public class Exposer {    private boolean exposed;    //一种加密措施    private String md5;    private long seckillId;    //系统当前时间(毫秒)    private long now;    private long start;    private long end;    public Exposer(boolean exposed, String md5, long seckillId) {        this.exposed = exposed;        this.md5 = md5;        this.seckillId = seckillId;    }    public Exposer(boolean exposed, long seckillId,long now, long start, long end) {        this.exposed = exposed;        this.now = now;        this.start = start;        this.end = end;        this.seckillId = seckillId;    }    public Exposer(boolean exposed, long seckillId) {        this.exposed = exposed;        this.seckillId = seckillId;    }    public boolean isExposed() {        return exposed;    }    public void setExposed(boolean exposed) {        this.exposed = exposed;    }    public String getMd5() {        return md5;    }    public void setMd5(String md5) {        this.md5 = md5;    }    public long getSeckillId() {        return seckillId;    }    public void setSeckillId(long seckillId) {        this.seckillId = seckillId;    }    public long getNow() {        return now;    }    public void setNow(long now) {        this.now = now;    }    public long getStart() {        return start;    }    public void setStart(long start) {        this.start = start;    }    public long getEnd() {        return end;    }    public void setEnd(long end) {        this.end = end;    }    @Override    public String toString() {        return "Exposer{" +                "exposed=" + exposed +                ", md5='" + md5 + '\'' +                ", seckillId=" + seckillId +                ", now=" + now +                ", start=" + start +                ", end=" + end +                '}';    }}
```

#### 封装秒杀操作后的结果

```java
package com.sorrymaker.seckill.dto;import com.sorrymaker.seckill.entity.SuccessKilled;import com.sorrymaker.seckill.enums.SeckillStatEnum;/** * 封装秒杀执行后结果 * @Author nextGame * @Date 2021/8/8 16:54 * @Version 1.0 */public class SeckillExecution {    private long seckillId;    //秒杀执行结果状态    private int state;    private String stateInfo;    //秒杀成功对象    private SuccessKilled successKilled;    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {        this.seckillId = seckillId;        this.state = statEnum.getState();        this.stateInfo = statEnum.getStateInfo();        this.successKilled = successKilled;    }    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {        this.seckillId = seckillId;        this.state = statEnum.getState();        this.stateInfo = statEnum.getStateInfo();    }    public long getSeckillId() {        return seckillId;    }    public void setSeckillId(long seckillId) {        this.seckillId = seckillId;    }    public int getState() {        return state;    }    public void setState(int state) {        this.state = state;    }    public String getStateInfo() {        return stateInfo;    }    public void setStateInfo(String stateInfo) {        this.stateInfo = stateInfo;    }    public SuccessKilled getSuccessKilled() {        return successKilled;    }    public void setSuccessKilled(SuccessKilled successKilled) {        this.successKilled = successKilled;    }}
```

#### 封装了json结果，给前端用（步骤11补充的一步）

```
package com.sorrymaker.seckill.dto;/** * 用来封装json结果 * * @Author nextGame * @Date 2021/8/10 20:21 * @Version 1.0 */public class SeckillResult<T> {    private boolean success;    private T data;    private String error;    public SeckillResult(boolean success, String error) {        this.success = success;        this.error = error;    }    public SeckillResult(boolean success, T data) {        this.success = success;        this.data = data;    }    public boolean isSuccess() {        return success;    }    public void setSuccess(boolean success) {        this.success = success;    }    public T getData() {        return data;    }    public void setData(T data) {        this.data = data;    }    public String getError() {        return error;    }    public void setError(String error) {        this.error = error;    }}
```



### 4、Service的实现接口设计

SeckillService.java

```java
package com.sorrymaker.seckill.service;import com.sorrymaker.seckill.dto.Exposer;import com.sorrymaker.seckill.dto.SeckillExecution;import com.sorrymaker.seckill.entity.Seckill;import com.sorrymaker.seckill.enums.SeckillStatEnum;import com.sorrymaker.seckill.exception.RepeatKillException;import com.sorrymaker.seckill.exception.SeckillCloseException;import com.sorrymaker.seckill.exception.SeckillException;import java.util.List;/** * 业务接口：站在“使用者”角度设计接口 * 三个方面：方法定义粒度、参数、返回类型（return  类型/异常） * 应该关注执行秒杀，而不是关注秒杀怎么减库存。使用者怎么友好的使用 * 方法定义粒度 -->> 把所有方法都应该想到 * 参数 -->> 越简练越好。 * @Author nextGame * @Date 2021/8/8 16:41 * @Version 1.0 */public interface SeckillService {    /**     * 查询所有秒杀记录     * @return     */    List<Seckill> getSeckillList();    /**     * 查询单个秒杀记录     * @param seckillId     * @return     */    Seckill getById(long seckillId);    /**     * 秒杀开始时，输出秒杀接口地址，否则输出系统时间和秒杀时间。     * @param seckillId     * @return     */    Exposer exportSeckillUrl(long seckillId);    /**     * 执行秒杀操作     * @param seckillId     * @param userPhone     * @param md5     */    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)        throws SeckillException, RepeatKillException, SeckillCloseException;}
```

### 5、接口的实现类

```java
package com.sorrymaker.seckill.service.impl;import com.sorrymaker.seckill.dao.SeckillDao;import com.sorrymaker.seckill.dao.SuccessKilledDao;import com.sorrymaker.seckill.dto.Exposer;import com.sorrymaker.seckill.dto.SeckillExecution;import com.sorrymaker.seckill.entity.Seckill;import com.sorrymaker.seckill.entity.SuccessKilled;import com.sorrymaker.seckill.enums.SeckillStatEnum;import com.sorrymaker.seckill.exception.RepeatKillException;import com.sorrymaker.seckill.exception.SeckillCloseException;import com.sorrymaker.seckill.exception.SeckillException;import com.sorrymaker.seckill.service.SeckillService;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import org.springframework.util.DigestUtils;import java.util.Date;import java.util.List;/** * @Author nextGame * @Date 2021/8/9 19:17 * @Version 1.0 */@Servicepublic class SeckillServiceImpl implements SeckillService {    private Logger logger = LoggerFactory.getLogger(this.getClass());    @Autowired    private SeckillDao seckillDao;    @Autowired    private SuccessKilledDao successKilledDao;    //md5盐值字符串，用于混淆md5    private final String slat = "sdasd_+d121@@asjj21..;da";    private String getMd5(long seckillId) {        String base = seckillId + "/" + slat;        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());        return md5;    }    public List<Seckill> getSeckillList() {        return seckillDao.queryAll(0, 100);    }    public Seckill getById(long seckillId) {        return seckillDao.queryById(seckillId);    }    public Exposer exportSeckillUrl(long seckillId) {        Seckill seckill = seckillDao.queryById(seckillId);        if (seckill == null) {            return new Exposer(false, seckillId);        }        Date startTime = seckill.getStartTime();        Date endTime = seckill.getEndTime();        Date nowTime = new Date();        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(),                    endTime.getTime());        }        //加入特定字符串，不可逆。        String md5 = getMd5(seckillId);        return new Exposer(true, md5, seckillId);    }    @Transactional    /**     * 使用注解控制事务方法的优点：     *      1：明确标注事务方法的编程风格。     *      2：保证事务方法的执行时间尽可能短，不要穿插其他的网路操作，HTTP请求，RPC请求。或者把网络操作剥离到事务外部。     *      3：不是所有的方法都需要事务，只有一条修改操作，只读操作不需要事务的控制。     *     */    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)            throws SeckillException, RepeatKillException, SeckillCloseException {        if (md5 == null || !md5.equals(getMd5(seckillId))) {            throw new SeckillException("Seckill date rewrite");        }        //执行秒杀逻辑：减库存加购买记录        Date nowTime = new Date();        /*        这里把减库存和记录购买行为调换了位置，        本来应该是先减少库存，再去记录购买行为。        但是这样子，每次都下减少库存后，再判断是否重复秒杀，再记录购买行为        这样子多了一步，我们优化mysql，先去判断是否重复秒杀，再去减库存，优化了一点。         */        try {            //记录购买行为            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);            if (insertCount <= 0) {                //重复秒杀                throw new RepeatKillException("seckill is repeated");            } else {                //减库存                int updateCount = seckillDao.reduceCount(seckillId, nowTime);                if (updateCount <= 0) {                    //没有更新到记录，秒杀结束                    throw new SeckillCloseException("seckill is closed");                //唯一：seckillId,userPhone                } else {                    //秒杀成功                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);                    return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS );                }            }        } catch (SeckillCloseException e1) {            throw e1;        } catch (SeckillException e2) {            throw e2;        } catch (Exception e) {            logger.error(e.getMessage(), e);            //所有编译期的异常转化为运行期异常。            throw new SeckillException("seckill inner error:" + e.getMessage());        }    }}
```

### 6、编写Service单元测试类（略）

## 八、Spring相关配置

###spring-service.xml

```xml
<?xml version="1.0" encoding="UTF-8"?><beans xmlns="http://www.springframework.org/schema/beans"       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       xmlns:context="http://www.springframework.org/schema/context"       xmlns:tx="http://www.springframework.org/schema/tx"       xsi:schemaLocation="http://www.springframework.org/schema/beans       http://www.springframework.org/schema/beans/spring-beans.xsd       http://www.springframework.org/schema/context       http://www.springframework.org/schema/context/spring-context.xsd       http://www.springframework.org/schema/tx       http://www.springframework.org/schema/tx/spring-tx.xsd">    <!--扫描service包下所有使用注解的类型 -->    <context:component-scan base-package="com.sorrymaker.seckill.service"/>    <!--配置事务管理器 -->    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">        <!-- 注入数据库连接池 -->        <property name="dataSource" ref="dataSource"/>    </bean>    <!-- 配置基于注解的声明式事务,默认使用注解来管理事务 -->    <tx:annotation-driven transaction-manager="transactionManager"/></beans>
```

对事务的操作，用这个方式。

在方法中加入注解@Transactional

###日志的基础配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?><configuration debug="true">    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">        <encoder>            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>        </encoder>    </appender>    <root level="debug">        <appender-ref ref ="STDOUT"/>    </root></configuration>
```




## 九、配置SpringMVC框架

### 1、web.xml

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee                         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"         version="3.1"         metadata-complete="true">    <!--配置DispatcherServlet -->    <servlet>        <servlet-name>seckill-dispatcher</servlet-name>        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>        <!-- 配置springMVC配置需要加载的文件-->        <init-param>            <param-name>contextConfigLocation</param-name>            <param-value>classpath:spring/spring-*.xml</param-value>        </init-param>    </servlet>    <servlet-mapping>        <servlet-name>seckill-dispatcher</servlet-name>        <!-- 默认匹配所有的请求，所有请求都会到dispatcherservlet. -->        <url-pattern>/</url-pattern>    </servlet-mapping></web-app>
```

### 2、sping-web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?><beans xmlns="http://www.springframework.org/schema/beans"       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       xmlns:mvc="http://www.springframework.org/schema/mvc"       xmlns:context="http://www.springframework.org/schema/context"       xsi:schemaLocation="http://www.springframework.org/schema/beans       http://www.springframework.org/schema/beans/spring-beans.xsd       http://www.springframework.org/schema/mvc       http://www.springframework.org/schema/cache/spring-mvc.xsd       http://www.springframework.org/schema/context       http://www.springframework.org/schema/context/spring-context.xsd">    <!-- 配置springMVC-->    <!-- 1、开启MVC注解模式            简化了配置：                   (1)自动注册DefaultAnnotationHandlerMapping,AnnotationMethodHandlerAdapter                   (2)提供了一系列的功能：数据绑定，数字和日期的format。xml，json默认读写支持。    -->    <mvc:annotation-driven/>    <!-- servlet-mapping 映射路径： “/”-->    <!-- 2:静态资源默认servlet配置            1):加入对静态资源的处理，js，gif，png            2):允许使用"/"进行整体映射    -->    <mvc:default-servlet-handler/>    <!--3:配置jsp显示，显示viewResolver-->    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>        <property name="prefix" value="/WEB-INF/jsp"/>        <property name="suffix" value=".jsp"/>    </bean>    <!-- 4:扫描web相关的bean-->    <context:component-scan base-package="com.sorrymaker.seckill.web"/></beans>
```



## 十、写Controller控制层 

```java
package com.sorrymaker.seckill.web;import com.sorrymaker.seckill.dto.Exposer;import com.sorrymaker.seckill.dto.SeckillExecution;import com.sorrymaker.seckill.dto.SeckillResult;import com.sorrymaker.seckill.entity.Seckill;import com.sorrymaker.seckill.enums.SeckillStatEnum;import com.sorrymaker.seckill.exception.RepeatKillException;import com.sorrymaker.seckill.exception.SeckillCloseException;import com.sorrymaker.seckill.exception.SeckillException;import com.sorrymaker.seckill.service.SeckillService;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;import java.util.Date;import java.util.List;/** * @Author nextGame * @Date 2021/8/8 16:32 * @Version 1.0 */@Controller@RequestMapping("/seckill") //url： /模块/资源/{id}/细分/seckill/listpublic class SeckillController {    private Logger logger = LoggerFactory.getLogger(this.getClass());    @Autowired    private SeckillService seckillService;    @RequestMapping(name = "/list", method = RequestMethod.GET)    public String liset(Model model) {        //获取列表页        List<Seckill> seckillList = seckillService.getSeckillList();        model.addAttribute("list", seckillList);        //list.jsp+model = ModelAndView        return "list";    }    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {        if (seckillId == null) {            return "redirect:/seckill/list";        }        Seckill seckill = seckillService.getById(seckillId);        if (seckill == null) {            return "forward:/seckill/list";        }        model.addAttribute("seckill", seckill);        return "detail";    }    //ajax接口，返回类型json    @ResponseBody //这个注解告诉spring，把返回类型封装成json。    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,            produces = {"application/json;charset=UTF-8"})//json里面乱码问题可以得到解决。    public SeckillResult<Exposer> exposer(Long seckillId) {        SeckillResult<Exposer> seckillResult;        try {            Exposer exposer = seckillService.exportSeckillUrl(seckillId);            seckillResult = new SeckillResult<Exposer>(true, exposer);        } catch (Exception e) {            logger.error(e.getMessage(), e);            seckillResult = new SeckillResult<Exposer>(false, e.getMessage());        }        return seckillResult;    }    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,            produces = {"application/json;charset=UTF-8"})    public SeckillResult<SeckillExecution> excute(@PathVariable("seckillId") Long seckillId,                                                  @PathVariable("md5") String md5,                                                  @CookieValue(value = "killPhone", required = false) Long userPhone) {        if (userPhone == null) {            return new SeckillResult<SeckillExecution>(false, "未注册");        }        SeckillResult<SeckillExecution> result;        try {            SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);            return new SeckillResult<SeckillExecution>(true, execution);        } catch (RepeatKillException e1) {            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);            return new SeckillResult<SeckillExecution>(false, execution);        } catch (SeckillCloseException e2) {            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);            return new SeckillResult<SeckillExecution>(false, execution);        } catch (Exception e) {            logger.error(e.getMessage(), e);            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);            return new SeckillResult<SeckillExecution>(false, execution);        }    }    @RequestMapping(value = "/time/now",method = RequestMethod.GET)    public SeckillResult<Long> time(){        Date nowTime = new Date();        return new SeckillResult<Long>(true,nowTime.getTime());    }}
```



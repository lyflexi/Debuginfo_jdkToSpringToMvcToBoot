# debuginfo_jdkToFramework

为什么要创建该项目？

只有深入理解各类框架的设计原理，才能在工作过程中也会更加高效准确地使用平台工具，提高应用程序的质量。

## 版本说明
框架版本说明：本仓库混合了两套Spring版本,分别是
- springboot 3.0.0、spring-framework 6.0.2、spring-webmvc 6.0.2
- springboot 2.7.18、spring-framework 5.3.31、spring-webmvc 5.3.31

问题1：为什么不用更高版本的springboot? 
- 答：可以使用更高的springboot版本，但是基于当前最新的spring-cloud2022只能支持springboot到3.0.0

问题2：为什么一个仓库混用两套springboot版本?
- 答：目前xxl-job最新版本只支持springboot2.7.18、spring-5.3.31，要对xxl-job的spring版本进行升级成本较高，故暂未调整

本仓库涵盖以下源码级调试案例，细细品读最佳实践，相信你会更加具有竞争力！
## 基于springboot 3.0.0、springframework 6.0.2
- jdk 17，springboot3统一升级jdk17
- springframework 6.0.2
- springmvc 6.0.2
- springframework-custom源码级修改版,调试三级缓存
- servlet 3.0+
- jakarta.servlet-api 5.0.0，springboot3统一升级javax为jakarta
- tomcat 10.1.7
- servlet路线
- 响应式编程reactive路线，敬请期待......
- 分布式锁系列
  - MySQL 5/8
  - redisTemplate
  - Redisson3.23
  - zookeeper3.7
  - Curator4.3
- 缓存系列
  - jetcache
- 消息中间件系列
  - rocketmq 4.9.2
  - rabbitmq 
- spring.cloud.alibaba 2022.0.0.0-RC2
- spring.cloud 2022.0.0
## 基于springboot2.7.18、springframework 5.3.31
- jdk 8
- javax.servlet-api
- xxl-job 2.4.2-SNAPSHOT
## 提供草图
- 其中drawio目录中绘制了部分原理草图
- 其中excalidraw目录中绘制了部分原理草图


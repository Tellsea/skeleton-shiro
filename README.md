# Skeleton

Skeleton 中文名称为 骨架 ，项目主要致力于如何进行快速开发，提高开发效率。并将模块组件化，达到开箱即食的境界

主要技术栈

|名称| 版本 |
|:--|:--|
| Spring Boot | 2.1.5.RELEASE |
| TKMybatis| 2.1.0 |
| Druid | 1.1.14 |
| mybatis-generator | 1.3.7 |
| Shiro | 1.4.1 |
| Swagger2 | 2.8.0 |

## 模块指南

- 基础工具

基于 Spring Boot 预先将常用功能进行统一制定，通常该模块下为文件上传下载，Excel导入导出，定制拦截器、监听器，AOP切面，事物回滚机制等常规属性配置，以及项目基础必备功能的工具类等
创爱你文件

 1. 文件上传、下载
 2. 数据导入、导出
 3. AOP操作日志记录
 4. Login登录日志记录

查看文档 →

- GenCode 代码生成器

采用 mybatis-generator + freemarker 的形式，制作输入表名字即可一键生成entity、controller、service、serviceImpl，mapper，xml 文件。并且定制 lombok 插件是的entity的代码浓缩90%

 1. 自动生成控制器
 2. 自动生成接口
 3. 自动生成接口实现类
 4. 自动生成映射接口
 5. 自动生成映射文件

查看文档 →

- Global 全局处理

该模块包含两个主要子模块，全局异常处理、公共结果集。解决前后端数据格式问题，和全局异常处理问题

 1. 全局异常处理
 2. 全局响应处理

查看文档 →

- Base 公共层

通过将常用的方法，接口，Mapper抽离出来，从而达到实际业务控制层无需一行代码，实现功能逻辑。抽离的层有：BaseController<T>，BaseService<T>，BaseServiceImpl<T>，MyMapper<T>

 1. 基类控制器
 2. 基类接口
 3. 基类接口实现类
 4. 基类映射接口
 5. 基类映射文件

查看文档 →

- Swagger 文档

该项目骨架支持前后端分离，比如说前端采用 JSP，Thymeleaf，Freemark，Vue 等模板引擎，并不会对骨架造成影响

 1. 自动生成Swagger接口文档
 2. 定制接口文档详细内容

查看文档 →

- TKMybatis 持久层

持久层采用封装了Mybatis的通用Mapper的形式，俗称的TkMybatis，一种封装力度更强的框架，使用起来非常简便，支持多种格式的数据处理，并且自带基本CRUD和构造条件的操作接口，Mapper层直接写接口 + 注解、或者XML 映射文件处理

 1. 默认继承父接口，实现基础功能
 2. 构造动态查询条件
 3. 使用注解与接口相结合
 4. XML操作映射文件
 5. 查询返回值处理

查看文档 →

- Shiro 权限控制

基于经典RBAC设计模式，user，user-role，role，role-resource，resource五张表控制全局权限。实现认证，授权账号不可同时登录等操作

 1. 认证、授权
 2. 动态权限管理
 3. 限制账号异地登录
 4. 登录之后返回原请求
 5. 在线会话管理
 6. 如何切换缓存工具

查看文档 →

- 防火墙

 1. 防御XSS攻击
 2. 防止SQL注入
 3. 防御CSRF

查看文档 →

- 线上部署

 1. 部署项目到Linux
 2. 同步更新项目源码

查看文档 →

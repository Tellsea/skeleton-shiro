# Skeleton
Skeleton 是一个基于 SpringBoot 的项目骨架，项目主要致力于如何进行快速开发，提高开发效率。并将模块组件化，达到开箱即食的境界

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190906153012598.png)

## 什么是Skeleton？

Skeleton 骨架是一个以 SpringBoot 为基础框架，整合与实际业务最贴合的持久层框架（因地制宜），以及其他优秀架构的项目。更多的你可以把它理解为项目基础架构构建工具。

通俗的说，算是大杂烩吧，通过知识点的综合累积，以及实际业务的开发需求，最终通过 Skeleton 来实现减少代码量，提高代码质量，加快项目开发速度。

## 架构起源

我是一名应届毕业生，有幸进入的一个充满蓬勃朝气的软件开发公司，怀里揣着做大事的信念，头破血流也不退缩的精神，从事着互联网软件开发的工作，为大数据的发展和崛起而奋斗。

初来乍到，请多关照。

通过公司项目的学习，以及相关知识的积累与扩展，发现一些实际项目中能优化，重构的地方，从而提升项目的复用性，高效性，稳定性，最大化浓缩代码量，尽量做到精简开发。

## 架构对比分析

注：纯属个人简洁，如有不对，请联系我纠正，谢谢

| 原技术 | Skeleton | 对比结果 |
| --- | --- | --- |
| Spring + Spring MVC | Spring Boot | 实际上是同样的东西，只不过Boot更加的简洁，是基于注解开发，配置文件最简化 |
| JDBC Templete | TKMybatis + JDBC Templete | 这里只不过是增加了一个持久层框架，后续会继续讲解为什么 |
| Filter + Listener | Shiro | Shiro 更加完整的符合企业级开发的实际需求 |
| Bootstrap | Layui | 前端根据实际情况而定 |

从架构上来看，并没有什么太大的变化，Skeleton 更多的是制定一些通用的，项目基础必备的，实用性的东西。比如说，全局异常统一处理、统一公共返回结果集、AOP切面等操作。这些实际上都是小问题，确实，三两行代码就能解决的问题，但是，千里之堤毁于蚁穴，懂了不做和不懂，是两种完全不同的情况和结果。

## 技术选型

我采用的核心技术栈是 SpringBoot + TKMybatis + JDBC Templete + Shiro

*   Spring Boot 实现“零配置文件”的梦想
*   TkMybatis 提前制定接口，直接调用即可，使持久层操作轻便化
*   JDBC Templete 目前来说，应该是市面上操作关联查询等的最佳框架
*   Shiro 对于企业级开发，更加贴合实际应用

其他相关技术在对应的模块中讲解，这里只列出核心技术栈作为对 Skeleton 的初步了解。

| 名称 | 版本 |
| --- | --- |
| Spring Boot | 2.1.5.RELEASE |
| TKMybatis | 2.1.0 |
| PageHelp | 1.2.3 |
| JDBC Templete | 2.1.5.RELEASE |
| Log4j | 1.2.17 |
| Shiro | 1.4.1 |
| Thymeleaf | 3.0.4 |
| Swagger2 | 2.8.0 |
| Freemark | 2.3.28 |
| Mybatis plus Generator | 3.0.6 |

## 核心技术栈

|名称| 版本 |
|:--|:--|
| Spring Boot | 2.1.5.RELEASE |
| TKMybatis| 2.1.0 |
| Druid | 1.1.14 |
| mybatis-generator | 1.3.7 |
| Shiro | 1.4.1 |
| Swagger2 | 2.8.0 |

## 参考文档

https://blog.csdn.net/qq_38762237/article/category/9332064

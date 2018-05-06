# Spring Boot 2.0极简教程

## —— 基于 Gradle + Kotlin 的企业级应用开发最佳实践



Spring Boot 是由 Pivotal 团队提供的全新框架，其设计目的是用来简化新 Spring 应用的初始搭建以及开发过程。在 Java 开发领域的诸多著名框架：Spring 框架及其衍生框架、做缓存Redis、消息队列框架RabbitMQ、Greenplum数据库等等，这些都是 Pivotal 团队的产品。还有Tomcat、Apache Http Server、Groovy里的一些顶级开发者，DevOps理论的提出者都在Pivotal。Spring 团队在现有 Spring 框架的基础上，开发了一个新框架:Spring Boot，用来简化配置和部署 Spring 应用程序的过程，干掉了那些繁琐的开发步骤和样板代码及其配置，使得基于 Spring 框架的 Java 企业级应用开发“极简化”。相比于传统的 Spring/Spring MVC 框架的企业级应用开发(Spring 的各种配置太复杂了，我们之前是在用“生命”在搞这些配置)，而Spring Boot 用简单的注解和 application.properties 配置文件，避免了繁琐而且容易出错的 xml配置文件，极大的简化了基于 Spring 框架的企业级应用开发的配置。

而 Kotlin 是由 JetBrains 团队开发的多平台、静态类型、强工程实用性的编程语言，Kotlin 100% 兼容Java，比Java更强大、更安全、更简洁、更优雅，比 Scala 更简单、更实用。Kotlin 是 Google 公司的 Android 官方支持的开发语言。Spring 官方也正式支持Kotlin语言，Spring Boot 2.0 版本中为 Kotlin 提供了一流的支持。其实，在 Spring Boot 2.0 和 Spring 5.0 框架源代码中，我们已经可以看到 Kotlin 代码。

至于Java 开发领域的项目构建工具，曾经的 Ant、Maven 无疑是“行业标准”。但是，作为后起之秀的 Gradle 的发展则如日中天。Gradle抛弃了Maven的基于 xml 的繁琐配置（众所周知XML的阅读体验比较差），Gradle 取而代之，采用了领域特定语言 Groovy DSL 的配置，大大简化了构建代码的行数。Gradle 极其简洁，基于Groovy的紧凑脚本让人爱不释手；Gradle 强大灵活，各种在Maven中难以下手的事情在 Gradle 中就是小菜一碟。相比于一门 Groovy 编程语言的配置跟 xml 语法的配置，孰优孰劣，显而易见。


本系列课程介绍了基于 Gradle + Kotlin 、使用 Spring Boot 2.0 框架来开发企业级应用的最佳实践。我希望通过简练的表述、详细的演示，系统全面地介绍如何使用 Spring Boot 2.0 框架开发项目，以及如何 Kotlin 进行实际的服务端项目的开发。

Gradle 执行测试命令：

```
$ gradle clean test --info
```
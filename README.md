# 高考志愿推荐系统_后端

![GitHub](https://img.shields.io/github/license/electronic-pig/gkvr_system_backend)
![GitHub Release](https://img.shields.io/github/v/release/electronic-pig/gkvr_system_backend)
![Static Badge](https://img.shields.io/badge/collaborator-3-lightblue)
![jdk version](https://img.shields.io/badge/jdk-17+-orange.svg)
![GitHub Issues or Pull Requests](https://img.shields.io/github/issues-closed/electronic-pig/gkvr_system_backend)
![GitHub Repo stars](https://img.shields.io/github/stars/electronic-pig/gkvr_system_backend)

## ✨ 简介

一个前后端分离的高考志愿推荐系统(gaokao volunteer recommendation system)

若您对项目前端感兴趣，请前往[前端仓库](https://github.com/electronic-pig/gkvr_system_frontend)

## 🛠 技术栈

| [Spring Boot 3.2.3](https://springdoc.cn/spring-boot/) | [MyBatis-Plus 3.5.5](https://baomidou.com/) | [MySQL 5.7.44](https://dev.mysql.com/downloads/windows/installer/5.7.html) |
|:---:|:--:|:--:|
| [<img src="https://github.com/electronic-pig/gkvr_system_backend/assets/103497254/dda83365-cda4-4ae9-bd10-9c379e267e7a" alt="springboot" height="100px"/>](https://springdoc.cn/spring-boot/) | [<img src="https://github.com/electronic-pig/gkvr_system_backend/assets/103497254/a45933bd-549f-4636-88bf-0d79babe41d3" alt="mybatisPlus" height="100px"/>](https://baomidou.com/) | [<img src="https://github.com/electronic-pig/gkvr_system_backend/assets/103497254/5fa43d20-c089-480c-a9af-f67b12e16ed1" alt="mysql5.7" height="100px"/>](https://dev.mysql.com/downloads/windows/installer/5.7.html) |

## 🗄️ 数据库

本项目使用`MySQL 5.7.44`作为数据库，数据库脚本已在[Releases](https://github.com/electronic-pig/gkvr_system_backend/releases)中的Assets里提供
## 🚀 运行

> [!Warning]
> 本项目的数据信息爬取自[掌上高考](https://www.gaokao.cn/)，项目成员对数据真实性不做任何保证，一切以学校官网为准

在执行后续步骤之前，请确保您配置好了以下环境：

- jdk ≥ 17
- maven ≥ 3
- mysql = 5.7.44

然后执行以下步骤

1. 在`pom.xml`刷新maven，加载项目依赖
2. 在`src/main/resources/application.yml`中配置数据库连接信息
3. 运行`GkvrSystemApplication.java`启动项目

## ⚙️ 算法

> [!Important]
> 本项目仅使用了**简单计算公式**来为用户推荐志愿和计算录取概率，推荐结果仅供参考
> 
> 项目的算法部分不是本项目的重点，建议开发者自行设计更加合理的算法模型

## 🤝 团队成员
本项目由以下三位开发者共同完成(不分先后)：[electronic-pig](https://github.com/electronic-pig)、[zf666fz](https://github.com/zf666fz)、[weeadd](https://github.com/weeadd)

v2版本的更新与维护由仓库所有者[electronic-pig](https://github.com/electronic-pig)完成

## ✍️ 写在最后
项目制作不易，如果它对你有帮助的话，请务必给作者点一个免费的⭐，万分感谢!🙏🙏🙏

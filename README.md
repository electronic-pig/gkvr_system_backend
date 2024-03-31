# 高考志愿推荐平台_后端

![GitHub](https://img.shields.io/github/license/electronic-pig/gkvr_system_backend)
![GitHub Release](https://img.shields.io/github/v/release/electronic-pig/gkvr_system_backend)
![Static Badge](https://img.shields.io/badge/collaborator-3-lightblue)
![jdk version](https://img.shields.io/badge/jdk-17+-orange.svg)
[![issues](https://img.shields.io/github/issues/electronic-pig/gkvr_system_backend?color=9cc)](https://github.com/electronic-pig/gkvr_system_backend/issues)
![GitHub Repo stars](https://img.shields.io/github/stars/electronic-pig/gkvr_system_backend)

## 🔥 最新动态 [2024/3/31] 
- 完成了对后端代码的重构，优化了数据库，更新了部分接口
- 新版本v2.0.0已发布，旧版本代码请查看tag v1.0.0

## ✨ 项目介绍

一个前后端分离的高考志愿推荐系统(gaokao volunteer recommendation system)

若您对项目前端感兴趣，请前往[前端仓库](https://github.com/electronic-pig/gkvr_system_frontend)

在线体验地址：[高考志愿推荐平台](http://lyserver.eastasia.cloudapp.azure.com/) (用户名：admin 密码：123456)

> [!NOTE]
> 本项目部署在小型云服务器上，服务器承载能力有限，可能会出现网址访问失败的情况

## 🛠 后端技术栈

|                                                                 [Spring Boot 3.2.3](https://springdoc.cn/spring-boot/)                                                                 |                                                                [MyBatis-Plus 3.5.5](https://baomidou.com/)                                                                |                                                                     [MySQL 5.7](https://dev.mysql.com/downloads/windows/installer/5.7.html)                                                                      |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| [<img src="https://github.com/Labhahaha/Yelp-Analysis-and-Reco/assets/95296826/3cd27a4b-7268-401a-afc9-ea9a118caa31" alt="flask" height="100px"/>](https://flask.palletsprojects.com/) | [<img src="https://github.com/Labhahaha/Yelp-Analysis-and-Reco/assets/95296826/56c66fc1-0491-4eae-bad5-4c08115c4776" alt="pytorch" height="100px"/>](https://pytorch.org) | [<img src="https://github.com/Labhahaha/Yelp-Analysis-and-Reco/assets/95296826/18254205-d00a-4f99-aa85-5e3d1dfbf1ab" alt="scikit-learn" height="80px"/>](https://scikit-learn.org/stable/index.html) |


## 📚 关于数据库(新版)

本项目使用`MySQL 5.7`作为数据库，数据库文件并未存放在本项目中，您可以通过提交issue的方式获取数据库文件

## 🚀 项目运行说明
> [!Warning]
> 本项目的数据信息爬取自[掌上高考](https://www.gaokao.cn/)，项目成员对数据真实性不做任何保证，一切以学校官网为准

在执行后续步骤之前，请确保您配置好了以下环境：

- jdk ≥ 17
- maven ≥ 3
- mysql = 5.7

然后执行以下步骤

* 在`pom.xml`刷新maven，加载项目依赖
* 在`src/main/resources/application.yml`中配置数据库连接信息
* 运行`GkvrSystemApplication.java`启动项目


## 🧰 关于算法

> [!Important]
> 本项目仅使用了简单计算公式来为用户推荐志愿和计算录取概率，推荐结果仅供参考
> 
> 项目的算法部分不是本项目的重点，建议开发者自行设计更加合理的算法模型

## 💖 团队成员
本项目由以下三位开发者共同完成(排名不分先后)：[electronic-pig](https://github.com/electronic-pig)、[zf666fz](https://github.com/zf666fz)、[weeadd](https://github.com/weeadd)

v2.0.0版本的更新与维护由仓库所有者[electronic-pig](https://github.com/electronic-pig)完成
## 📄 写在最后
项目制作不易，如果它对你有帮助的话，请务必给作者点一个免费的⭐，万分感谢!🙏🙏🙏

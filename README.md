## 选课系统1.0

### 环境：
本地调试版

方面|细节
---|---
* 开发工具|Intellij IDEA 2017.1.3
* springboot|**2.0.1.RELEASE**
* jdk| 1.8.0_40
* maven| 3.3.9
* alibaba Druid 数据库连接池|1.1.0
* 数据库| mysql

### 日志
+ 日志使用的是Logpack

### CAS
+ CAS 使用的是Spring Security

### 后端
+ Mybatis


### 功能实现：

### Git操作

1. 本地commit（IDEA工具，项目上右键）
2. 获取master最新代码
    git fetch origin master
3. 合并master代码
    git merge origin/master
4. 如果有冲突，解决（查看version control，红色的文件）
    解决冲突后，把红色的文件，右键 - git - add 
    再次commit
5. push
    git push
    （如果提示，按照提示操作，如git push --set-upstream origin zhao）
6. 发送merge请求（在浏览器上提交）

### [DateBase](DB.md)
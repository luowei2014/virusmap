# virusmap
I did a project on viruses in China,I hope my country will be rejuvenated

项目架构
mysql数据库
springboot2.0
mybaits以及mybatis-generator和pageHelper,mybatis-generator用于生成实体类和mapper以及DAO。
webmagic(Java爬虫框架，爬取疫情信息)

模块
1，processor，这是爬虫模块，抓去信息然后入库。
2，schedule，定时器模块，用于定时启动爬虫。
3，Controller，web数据拉取接口。

创建数据库的时候，名字最好也要叫  virus

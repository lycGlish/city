#1.0.0springboot发布版
##项目api
    1.基于TensorFlow的图片识别接口 http://120.26.65.52:5000/detect?url=
    2.基于FastDFS的分布式文件存储服务 http://120.26.65.52:22122 配置文件见fdfs_client.conf
    3.基于百度地图的经纬度搜索 http://api.map.baidu.com/geocoding/v3/?address=
##项目结构
###java
    1.bean 存储项目实体类
    2.configurar 进行错误统一处理，如404,500
    3.controller 业务层，进行前后端交互
    4.dao 持久层，对数据库进行操作，采用mysql数据库和mybatis框架
    5.fastdfs 图片存储功能，将图片上传至linux，并返回url
    6.interceptor 拦截器，将未登录的用户拦截至主页
    7.service 服务层，将业务层操作与持久层操作绑定
    8.test 单元测试
    9.util 工具类，包括百度地图经纬度搜索，Json转String，md5加密，Python图片识别,mybatis逆向工程工具
###resources
    1.mapper mybatis对数据库的映射处理
    2.static 网页静态文件，如，CSS，JS等
    3.templates 网页文件，分为主页，管理页，测试页，用户页和错误页
    4.application.yml Springboot的配置文件
    5.mgb-city.xml mybatis逆向工程配置文件
##数据库（mysql）
    1.数据库表放在sql中
    2.数据结构图示在思维导图中
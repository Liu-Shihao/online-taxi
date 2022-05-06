<h1>网约车项目</h1>

# 一、项目架构

服务名|服务|端口
----|-----|-----
cloud-eureka|注册中心|7900|
api-passenger |乘客端接口|9000
service-verification-code| 验证码服务|9001
service-sms|短信服务|9002
cloud-zuul|网关服务|9003|
service-passenger-user|乘客端业务模块|9004|
service-valuation|计价服务|9005|
api-listen-order|派单服务|9006|



# 项目优化
1. Eureka
2. 生成验证码效率优化
3. 线程数优化：cpu可用核数 / (1-阻塞系数) ；（阻塞系数：IO密集型j接近1；计算密集型接近0）

提升QPS主要两点：
1. 提升并发数
    1. 使用多线程
    2. 增加各种连接数（mysql、redis、Tomcat、redis
    3. 服务无状态，便于横向扩展，扩机器
2. 减少响应时间
    1. 异步
    2. 缓存（减少DB读取，减少磁盘IO）
    3. 数据库优化
    4. 减少调用量    
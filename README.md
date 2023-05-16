# App_wallet_consumption
# 代码说明
业务背景：电商业务中，需要给电商app设计一个用户钱包，用户可以往钱包中充值，购买商品时用户可以使用钱包中的钱消费，商品申请退款成功后钱会退回钱包中，用户也可以申请提现把钱提到银行卡中
用程序实现如下api接口
 1.  查询用户2钱包余额
 ```
 GET: http://localhost:8080/wallet/balance/2
 ```
2. 用户2消费100元的接口
```
POST: http://localhost:8080/wallet/consume/2
```
3. 用户2退款20元接口
```
POST: http://localhost:8080/wallet/refund/2
```
4. 查询用户2钱包金额变动明细的接口
```
GET: http://localhost:8080/transactions/transactions/2
```
# 数据库文件
```
database.sql
```
# 项目代码包含2个分支：
- master : 主分支，包含完整版代码
- main : 空
# 下载
克隆完整项目
```
https://github.com/DGS666/App_wallet_consumption.git
```
# 技术

Spring Boot

Mybatis-Plus

MySQL

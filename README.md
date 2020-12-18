# Fabric2.0JavaSdkDemo
该项目提供了fabric2.0的javasdk的使用案例，仅供参考。需要修改具体的证书和域名，以适应自己的系统。
## 功能
1.安装链码（可以自动下载链码需要的依赖，安装成功后自动删除链码和依赖文件）
2.初始化链码
3.执行链码
4.查询链码
5.获取节点加入的通道
6.获取节点安装的所有链码
## maven
```
<dependencies>
  <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.75</version>
  </dependency>
  	<dependency>
    <groupId>org.hyperledger.fabric-sdk-java</groupId>
    <artifactId>fabric-sdk-java</artifactId>
    <version>2.0.0</version>
  </dependency>
</dependencies>
```

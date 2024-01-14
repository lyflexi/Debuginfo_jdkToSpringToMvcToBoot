proxy-none-java-file中代理业务写死在了$Proxy0.java中了，也就是说$Proxy0.java是针对所有接口的同一类型的代理处理，这显然不对，我们需要的是通用的代理类；

业务处理规范化，提供统一的规范接口：InvocationHandler，供用户自定义业务逻辑
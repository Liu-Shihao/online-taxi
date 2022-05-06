<h1>Zuul网关使用指南</h1>

# 一、路由转发
## 1. 自动转发
直接访问网关服务ip:port/spring.application.name(被调用方的服务名)/path 即可转发


http://localhost:9003/api-passenger/test  ->   http://localhost:9000/test 


# 二、过滤器
继承extends ZuulFilter 创建自定义过滤器，：可以实现服务鉴权、日志记录等操作：

```java
@Component
public class GrayFilter extends ZuulFilter {

    /**
     * 当前过滤器是否开启true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 拦截后的具体业务逻辑
     * 过滤器内执行的操作 return 任何ojbect的值都表示继续执行
     * setsendzullRespponse(false)表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {


        return null;
    }
    /**
     * 拦截类型：4中类型
     * 在请求前pre或者后post执行
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 	多个过滤器的执行顺序，数字越小，表示越先执行
     */
    @Override
    public int filterOrder() {
        return 1;
    }

}

```


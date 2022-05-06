package com.lsh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:02 下午
 * @desc ：网关实现灰度发布
 */
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

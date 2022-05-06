package com.lsh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import con.lsh.common.constant.RedisKeyPrefixConstant;
import con.lsh.common.util.JwtInfo;
import con.lsh.common.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:02 下午
 * @desc ：鉴权过滤
 */
//@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**
     * 	该过滤器是否生效
     */
    @Override
    public boolean shouldFilter() {

        return true;
    }

    /**
     * 	拦截后的具体业务逻辑
     */
    @Override
    public Object run() throws ZuulException {

        System.out.println("auth 拦截");
        //获取上下文（重要，贯穿 所有filter，包含所有参数）
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        parseBody(request);

        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token)){
            JwtInfo tokenJwtInfo = JwtUtil.parseToken(token);

            if(null != tokenJwtInfo) {
                String tokenUserId = tokenJwtInfo.getSubject();
                Long tokenIssueDate = tokenJwtInfo.getIssueDate();

                BoundValueOperations<String, String> stringStringBoundValueOperations = stringRedisTemplate.boundValueOps(RedisKeyPrefixConstant.PASSENGER_LOGIN_TOKEN_APP_KEY_PRE + tokenUserId);
                String redisToken = stringStringBoundValueOperations.get();
//                if (redisToken.equals(token)){
//
//
//                    return null;
//                }
            }
        }

        // 不往下走，还走剩下的过滤器，但是不向后面的服务转发。
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        requestContext.setResponseBody("auth fail");

//        requestContext.set("ifContinue",false);

        return null;
    }
    /**
     * 拦截类型，4中类型。
     */
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 	值越小，越在前
     */
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return -1;
    }


//	private void parseBody(HttpServletRequest request){
//        Map<String,Object> params = new HashMap<String, Object>();
//        BufferedReader br;
//        try {
//            br = request.getReader();
//            String str, wholeStr = "";
//            while((str = br.readLine()) != null){
//                wholeStr += str;
//            }
//            if(StringUtils.isNotEmpty(wholeStr)){
//                JSONObject jsonObject = JSONObject.fromObject(wholeStr);
//            }
//        } catch (IOException e1) {
//
//        }
//
//    }
}

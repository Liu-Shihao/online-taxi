package com.lsh.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 3:41 下午
 * @desc ：
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
        System.out.println("---===网关服务启动===---");
    }
}

package com.lsh.apipassenger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//@EnableEurekaClient  Eureka客户端不加@EnableEurekaClient注解也可以使用，真正控制的开关是eureka.client.enabled，默认是开启的
@SpringBootApplication
public class ApiPassengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class, args);


    }

    //使用Google的guava创建一个本地缓存
    @Bean
    LoadingCache<String, Object> cache(){
        return  CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String o) throws Exception {
                        return "load:" + new Random().nextInt(100);
                    }
                });
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

package com.lsh.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:19 下午
 * @desc ：
 */
@SpringBootApplication
public class SmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class,args);
        System.out.println("---===短信服务启动===---");
    }
}

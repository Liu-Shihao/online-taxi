package com.lsh.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:29 下午
 * @desc ：
 */
@SpringBootApplication
public class VerificationCodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VerificationCodeApplication.class,args);
        System.out.println("---===验证码服务启动===---");
    }
}

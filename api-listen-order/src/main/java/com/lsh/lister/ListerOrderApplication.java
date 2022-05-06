package com.lsh.lister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/5 10:32 下午
 * @desc ：
 */
@SpringBootApplication
public class ListerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListerOrderApplication.class,args);
        System.out.println("---===派单服务启动===---");
    }
}

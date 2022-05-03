package com.lsh.servicepassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 5:10 下午
 * @desc ：
 */
@SpringBootApplication
public class ServicePassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePassengerApplication.class,args);
        System.out.println("---===乘客端业务模块启动===---");
    }
}

package com.lsh.valuation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/4 4:16 下午
 * @desc ：
 */
@SpringBootApplication
public class ValuationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValuationApplication.class,args);
        System.out.println("---===计价服务启动===---");
    }
}

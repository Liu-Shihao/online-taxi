package com.lsh.lister.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/5 10:49 下午
 * @desc ：
 */
@RestController
public class ListenController {
    @RequestMapping(value = "listen/{driverId}",produces = "text/event-stream;charset=utf-8")
    public String getStream(@PathVariable("driverId") int driverId){
        System.out.println("听单来了");

        String a = "asdfasdf";
        a.length();


        return "data:"+Math.random()+"\n\n";
    }
}

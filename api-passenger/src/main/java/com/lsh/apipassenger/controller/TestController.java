package com.lsh.apipassenger.controller;

import con.lsh.common.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/6 10:41 下午
 * @desc ：
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseResult test(){
        return ResponseResult.success(new Date());

    }
}

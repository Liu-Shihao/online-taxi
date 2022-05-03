package com.lsh.code.controller;

import com.lsh.code.service.VerifyCodeService;
import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.serviceverificationcode.request.VerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:30 下午
 * @desc ：
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 根据身份，手机号，生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity , @PathVariable ("phoneNumber") String phoneNumber) {
        log.info("/generate/{identity}/{phoneNumber} ： 身份类型："+identity+",手机号："+phoneNumber);
        return verifyCodeService.generateCode(identity,phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody VerifyCodeRequest request) {
        log.info("/verify-code/verify  request:"+ request);
        //获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verifyCodeService.verifyCode(identity,phoneNumber,code);

    }



}
package com.lsh.apipassenger.controller;

import com.lsh.apipassenger.request.ShortMsgRequest;
import com.lsh.apipassenger.service.VerificationCodeService;
import con.lsh.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 6:34 下午
 * @desc ：发送短信验证码
 */
@RestController
@RequestMapping("/verify-code")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/send")
    public ResponseResult send(@RequestBody @Validated ShortMsgRequest request){

        return verificationCodeService.send(request.getPhoneNumber());
    }
}

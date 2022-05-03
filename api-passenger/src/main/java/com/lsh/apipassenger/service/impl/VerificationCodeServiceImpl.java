package com.lsh.apipassenger.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lsh.apipassenger.service.ServiceSmsRestTemplateService;
import com.lsh.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import com.lsh.apipassenger.service.VerificationCodeService;
import con.lsh.common.constant.CommonStatusEnum;
import con.lsh.common.constant.IdentityConstant;
import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.serviceverificationcode.response.VerifyCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServiceSmsRestTemplateService serviceSmsRestTemplateService;

    @Override
    public ResponseResult send(String phoneNumber) {

        //1.获取验证码
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.generatorCode(IdentityConstant.PASSENGER,phoneNumber);
        log.info("____请求验证码服务返回：{}", JSONObject.toJSONString(responseResult.getData()));
        VerifyCodeResponse verifyCodeResponse = null;
        if (responseResult.getCode() == CommonStatusEnum.SUCCESS.getCode()){
            verifyCodeResponse =JSONObject.parseObject(JSONObject.toJSONString(responseResult.getData()),VerifyCodeResponse.class);
        }else {
            return ResponseResult.fail("获取验证码失败");
        }

        String code = verifyCodeResponse.getCode();
        //2.发送短信验证码
        ResponseResult result = serviceSmsRestTemplateService.sendSms(phoneNumber,code);
        if (result.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("发送短信 失败");
        }

        return ResponseResult.success("发送成功");

    }

    @Override
    public ResponseResult verify(String phoneNumber, String code) {

        return serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER,phoneNumber,code);
    }

}

package com.lsh.apipassenger.service.impl;

import com.lsh.apipassenger.service.AuthService;
import com.lsh.apipassenger.service.ServicePassengerUserService;
import com.lsh.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import con.lsh.common.constant.CommonStatusEnum;
import con.lsh.common.constant.IdentityConstant;
import con.lsh.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:33 下午
 * @desc ：
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServicePassengerUserService servicePassengerUserService;

    @Override
    public ResponseResult auth(String passengerPhone, String code) {
        // 验证验证码
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER,passengerPhone,code);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：验证码校验失败");
        }

        // 用户登录
        responseResult = servicePassengerUserService.login(passengerPhone);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：登录失败");
        }

        return responseResult;
    }

}

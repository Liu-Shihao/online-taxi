package com.lsh.apipassenger.controller;

import com.lsh.apipassenger.request.UserAuthRequest;
import com.lsh.apipassenger.service.AuthService;
import con.lsh.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:32 下午
 * @desc ：用户登录，校验短信验证码
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 用户登录
     * 校验短信验证码
     * @param userAuthRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated UserAuthRequest userAuthRequest) {

        String passengerPhone = userAuthRequest.getPassengerPhone();
        String code = userAuthRequest.getCode();

        return authService.auth(passengerPhone , code);

    }
}

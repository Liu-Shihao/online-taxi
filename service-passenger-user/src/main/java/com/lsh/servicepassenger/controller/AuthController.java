package com.lsh.servicepassenger.controller;

import com.lsh.servicepassenger.service.PassengerUserService;
import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.servicepassengeruser.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限控制类
 * 此类对用户的登录、权限和登出进行控制。
 *
 * @date 2022年05月03日17:15:12
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PassengerUserService passengerUserService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginRequest request){

        String passengerPhone = request.getPassengerPhone();
        return passengerUserService.login(passengerPhone);
    }

    /**
     *
     * @param token
     * @return
     * @throws Exception
     */
    @PostMapping("/logout")
    public ResponseResult logout(String token) throws Exception{
        passengerUserService.logout(token);
        return ResponseResult.success("");
    }
}

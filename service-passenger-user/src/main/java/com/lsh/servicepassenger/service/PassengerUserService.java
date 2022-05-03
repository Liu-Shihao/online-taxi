package com.lsh.servicepassenger.service;

import con.lsh.common.dto.ResponseResult;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 5:15 下午
 * @desc ：
 */
public interface PassengerUserService {
     ResponseResult login(String passengerPhone);

     ResponseResult logout(String token);
}

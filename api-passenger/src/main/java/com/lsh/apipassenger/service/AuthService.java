package com.lsh.apipassenger.service;

import con.lsh.common.dto.ResponseResult;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:32 下午
 * @desc ：
 */
public interface AuthService {

    ResponseResult auth(String passengerPhone, String code);
}

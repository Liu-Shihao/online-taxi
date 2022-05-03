package com.lsh.code.service;

import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.serviceverificationcode.response.VerifyCodeResponse;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:41 下午
 * @desc ：
 */
public interface VerifyCodeService {

    ResponseResult<VerifyCodeResponse> generateCode(int identity , String phoneNumber);

    ResponseResult verifyCode(int identity,String phoneNumber,String code);
}

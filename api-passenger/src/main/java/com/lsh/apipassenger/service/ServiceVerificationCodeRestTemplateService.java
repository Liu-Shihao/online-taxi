package com.lsh.apipassenger.service;

import con.lsh.common.dto.ResponseResult;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/3 4:34 下午
 * @desc ：
 */
public interface ServiceVerificationCodeRestTemplateService {
     ResponseResult generatorCode(int identity, String phoneNumber);

     ResponseResult verifyCode(int identity, String phoneNumber , String code);
}

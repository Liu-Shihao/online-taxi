package com.lsh.apipassenger.service;

import con.lsh.common.dto.ResponseResult;

public interface VerificationCodeService {

    public ResponseResult send(String phoneNumber);

    public ResponseResult verify(String phoneNumber, String code);
}

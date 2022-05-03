package com.lsh.apipassenger.service;

import con.lsh.common.dto.ResponseResult;

public interface ServiceSmsRestTemplateService {

    public ResponseResult sendSms(String phoneNumber, String code);
}

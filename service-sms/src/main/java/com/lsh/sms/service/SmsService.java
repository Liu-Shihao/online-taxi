package com.lsh.sms.service;

import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.servicesms.request.SmsSendRequest;

public interface SmsService {
	/**
	 * 发送短信
	 * @param request
	 * @return
	 */
	 ResponseResult sendSms(SmsSendRequest request);
}
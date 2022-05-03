package com.lsh.sms.controller;

import com.lsh.sms.service.SmsService;
import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.servicesms.request.SmsSendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:20 下午
 * @desc ：
 */
@RestController
@RequestMapping("/send")
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/sms-template",method = RequestMethod.POST)
    public ResponseResult send(@RequestBody SmsSendRequest smsSendRequest){
        //输出收到的参数内容
        log.info("/send/alisms-template   request："+smsSendRequest);
        return smsService.sendSms(smsSendRequest);
    }

}
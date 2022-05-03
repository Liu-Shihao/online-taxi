package com.lsh.code.service.impl;

import com.lsh.code.service.VerifyCodeService;
import con.lsh.common.constant.CommonStatusEnum;
import con.lsh.common.constant.IdentityConstant;
import con.lsh.common.constant.RedisKeyPrefixConstant;
import con.lsh.common.dto.ResponseResult;
import con.lsh.common.dto.serviceverificationcode.response.VerifyCodeResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/2 4:41 下午
 * @desc ：
 */
@Service
public class VerificationCodeServiceimpl implements VerifyCodeService {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 乘客端：passenger_login_code_phoneNumber：code
     * 司机端：driver_login_code_phoneNumber：code
     * 有效时间 5分钟
     * 生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    @Override
    public ResponseResult<VerifyCodeResponse> generateCode(int identity , String phoneNumber){

        //校验 发送时限，三挡验证，不能无限制发短信
//        checkSendCodeTimeLimit(phoneNumber);

        // 0.9*9=8.1+1 9,去掉首位为0的情况。 0.11225478552211(0.0-<1)
        String code = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10,5)));

        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        //存redis，2分钟过期
        BoundValueOperations<String, String> codeRedis = stringRedisTemplate.boundValueOps(key);

//        Boolean aBoolean = codeRedis.setIfAbsent(code);
//        if (aBoolean){
//            codeRedis.expire(5,TimeUnit.MINUTES);
//        }
        codeRedis.set(code,5,TimeUnit.MINUTES);

        //返回
        VerifyCodeResponse result = new VerifyCodeResponse();
        result.setCode(code);
        return ResponseResult.success(result);
    }

    @Override
    public ResponseResult verifyCode(int identity,String phoneNumber,String code){
        //三档验证
        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = stringRedisTemplate.boundValueOps(key);
        String redisCode = codeRedis.get();

        if(StringUtils.isNotBlank(code)
                && StringUtils.isNotBlank(redisCode)
                && code.trim().equals(redisCode.trim())) {

            return ResponseResult.success("");
        }else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }

    }


    /**
     * 判断此手机号发送时限限制
     * @param phoneNumber
     * @return
     */
    private ResponseResult checkSendCodeTimeLimit(String phoneNumber){
        //判断是否有 限制1分钟，10分钟，24小时。

        return ResponseResult.success("");
    }

    /**
     * 根据身份类型生成对应的缓存key
     * @param identity
     * @return
     */
    private String generateKeyPreByIdentity(int identity){
        String keyPre = "";
        if (identity == IdentityConstant.PASSENGER){
            keyPre = RedisKeyPrefixConstant.PASSENGER_LOGIN_CODE_KEY_PRE;
        }else if (identity == IdentityConstant.DRIVER){
            keyPre = RedisKeyPrefixConstant.DRIVER_LOGIN_CODE_KEY_PRE;
        }
        return keyPre;
    }

    /**
     * 三档验证校验
     * @param phoneNumber
     * @param code
     * @return
     */
    private ResponseResult checkCodeThreeLimit(String phoneNumber,String code){
        //看流程图

        return ResponseResult.success("");
    }

    /**
     * 两种生成验证码方式效率差异 5倍
     * @param args
     */
    public static void main(String[] args) {
        int num = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i <  num; i++) {
//            String code = String.valueOf((int)(Math.random()*1000000));
            String code = String.valueOf((int)((Math.random()*9+1)* Math.pow(10,5)));
        }
        System.out.println(System.currentTimeMillis()- start);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i <  num; i++) {
            String code = (Math.random()+"").substring(2,8);
        }
        System.out.println(System.currentTimeMillis()- start2);

    }
}

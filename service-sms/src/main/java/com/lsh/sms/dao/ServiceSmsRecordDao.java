package com.lsh.sms.dao;

import com.lsh.sms.entity.ServiceSmsRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceSmsRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceSmsRecord record);

    int insertSelective(ServiceSmsRecord record);

    ServiceSmsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceSmsRecord record);

    int updateByPrimaryKey(ServiceSmsRecord record);
}
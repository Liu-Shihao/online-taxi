package com.lsh.valuation.dao;

import com.lsh.valuation.mapper.DynamicDiscountRuleMapper;
import con.lsh.common.dto.valuation.discount.DiscountCondition;
import con.lsh.common.dto.valuation.discount.DiscountPrice;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 动态调价DAO
 *
 * @date 2018/8/20
 */
@Repository
@RequiredArgsConstructor
public class DynamicDiscountRuleDao {

    @NonNull
    private DynamicDiscountRuleMapper dynamicDiscountRuleMapper;

    /**
     * 根据检索条件查询调价信息
     * @param condition 检索条件
     * @return 调价信息
     */
    public DiscountPrice findDiscountByCondition(DiscountCondition condition){
        return dynamicDiscountRuleMapper.findDiscountByCondition(condition);
    }
}

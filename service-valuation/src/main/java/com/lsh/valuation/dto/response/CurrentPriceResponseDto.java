package com.lsh.valuation.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 实时价格DTO
 *
 * @date 2022年05月04日16:24:17
 */
@Data
@Accessors(chain = true)
public class CurrentPriceResponseDto {
    /**
     * 行驶距离（单位：米）
     */
    private double distance;

    /**
     * 价格
     */
    private BigDecimal price;
}

package com.mashibing.mongodb.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-11-28 22:56
 */
@Data
public class OrderDetail {

    /**
     * ID
     */
    private Long id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品编码
     */
    private String sku;
    /**
     * 购买数量
     */
    private Integer qty ;
    /**
     * 单价
     */
    private Integer price ;
    /**
     * 进货价格
     */
    private Integer cost ;
    /**
     * 库房编码--单位--包装规格....
     */
}

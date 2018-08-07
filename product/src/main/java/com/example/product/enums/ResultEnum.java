package com.example.product.enums;

import lombok.Getter;

/**
 * Created by 黄逸晖 on 2018-08-07.
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"商品库存不足"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message) {
        this.message = message;
        this.code = code;
    }
}

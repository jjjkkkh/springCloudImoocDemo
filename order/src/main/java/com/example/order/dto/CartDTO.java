package com.example.order.dto;

import lombok.Data;

/**
 * Created by 黄逸晖 on 2018-08-07.
 */
@Data
public class CartDTO {
    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }


}

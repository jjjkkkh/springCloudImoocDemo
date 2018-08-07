package com.example.product.exception;

import com.example.product.enums.ResultEnum;
import lombok.Data;

/**
 * Created by 黄逸晖 on 2018-08-07.
 */
@Data
public class ProductException extends Exception {

    private Integer code;

    private String message;

    public ProductException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ProductException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}

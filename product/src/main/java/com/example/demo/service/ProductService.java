package com.example.demo.service;

import com.example.demo.dataObject.ProductInfo;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-01.
 */
public interface ProductService {

    /*
    * 查询所有在架商品
    * */
    List<ProductInfo> findUpAll();
}

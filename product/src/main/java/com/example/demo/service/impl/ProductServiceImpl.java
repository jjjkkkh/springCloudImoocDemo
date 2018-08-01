package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.repository.ProductInfoRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-01.
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
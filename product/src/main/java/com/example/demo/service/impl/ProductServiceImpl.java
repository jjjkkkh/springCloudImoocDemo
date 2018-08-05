package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.repository.ProductInfoRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-01.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}

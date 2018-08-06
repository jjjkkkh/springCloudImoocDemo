package com.example.product.service.impl;

import com.example.product.dataObject.ProductInfo;
import com.example.product.enums.ProductStatusEnum;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.service.ProductService;
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

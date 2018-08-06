package com.example.product.service.impl;

import com.example.product.dataObject.ProductCategory;
import com.example.product.repository.ProductCategoryRepository;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-02.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}

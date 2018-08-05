package com.example.demo.service.impl;

import com.example.demo.dataObject.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-02.
 */
public class CategoryServiceImpl implements CategoryService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}

package com.example.demo.service;

import com.example.demo.dataObject.ProductCategory;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-02.
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

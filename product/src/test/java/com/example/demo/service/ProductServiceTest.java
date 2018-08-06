package com.example.demo.service;

import com.example.demo.ProductApplicationTests;
import com.example.product.dataObject.ProductInfo;
import com.example.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-02.
 */
public class ProductServiceTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void testFindUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
}
package com.example.product.service;

import com.example.product.dataObject.ProductInfo;
import com.example.product.dto.CartDTO;
import com.example.product.exception.ProductException;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-01.
 */
public interface ProductService {

    /*
    * 查询所有在架商品
    * */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品id集合查询商品信息
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     * @throws Exception
     */
    void decreaseProductStock(List<CartDTO> cartDTOList) throws Exception;
}

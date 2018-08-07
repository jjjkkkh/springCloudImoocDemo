package com.example.order.client;

import com.example.order.dataObject.ProductInfo;
import com.example.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by 黄逸晖 on 2018-08-07.
 */
@FeignClient("product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();


    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/product/decreaseProductStock")
    void decreaseProductStock(@RequestBody List<CartDTO> cartDTOList);

}

package com.example.order.service;

import com.example.order.dto.OrderDTO;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}

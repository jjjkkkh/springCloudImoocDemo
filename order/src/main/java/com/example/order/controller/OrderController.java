package com.example.order.controller;

import com.example.order.dataObject.OrderMaster;
import com.example.order.dto.OrderDTO;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderMasterRepository;
import com.example.order.utils.keyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */

    public OrderDTO create(OrderDTO orderDTO){
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(keyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);

        return orderDTO;

    }

}

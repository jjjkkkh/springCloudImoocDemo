package com.example.order.repository;

import com.example.order.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}

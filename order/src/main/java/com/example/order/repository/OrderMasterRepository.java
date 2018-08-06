package com.example.order.repository;

import com.example.order.dataObject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 黄逸晖 on 2018-08-06.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}

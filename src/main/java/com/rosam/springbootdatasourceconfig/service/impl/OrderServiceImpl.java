package com.rosam.springbootdatasourceconfig.service.impl;

import com.rosam.springbootdatasourceconfig.dao.OrderMapper;
import com.rosam.springbootdatasourceconfig.entity.Order;
import com.rosam.springbootdatasourceconfig.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String getMessageIdById(String orderId){
        Order order = orderMapper.selectByPrimaryKey(orderId);
        String messageId = order.getMessageId();
        return messageId;
    }

}

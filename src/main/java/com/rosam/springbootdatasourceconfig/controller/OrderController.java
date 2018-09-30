package com.rosam.springbootdatasourceconfig.controller;

import com.rosam.springbootdatasourceconfig.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getMessgeId",method = RequestMethod.GET)
    public String getMessageId(@RequestParam String orderId){
        String messageId = orderService.getMessageIdById(orderId);
        return messageId;
    }

    @RequestMapping("/probe")
    public String probe(){
        return "success";
    }

}

package com.example.orderbox2.service;

import com.example.orderbox2.dto.OrderCreationDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface OrderService {
    void createOrder(OrderCreationDto orderCreationDto);
}

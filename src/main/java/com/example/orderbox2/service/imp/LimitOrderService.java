package com.example.orderbox2.service.imp;

import com.example.orderbox2.dto.OrderCreationDto;
import com.example.orderbox2.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LimitOrderService implements OrderService {
    @Override
    @Transactional
    public void createOrder(OrderCreationDto orderCreationDto) {

    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void cancelOrder() {

    }
}

package com.example.orderbox2.service.imp;

import com.example.orderbox2.dto.OrderCreationDto;
import com.example.orderbox2.model.entity.OrderEntity;
import com.example.orderbox2.model.repository.OrderRepository;
import com.example.orderbox2.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class StopOrderService implements OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    public StopOrderService(ModelMapper modelMapper, OrderRepository orderRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void createOrder(OrderCreationDto orderCreationDto){
        orderCreationDto.validateCreationOrder();
        OrderEntity order = modelMapper.map(orderCreationDto, OrderEntity.class);
        orderRepository.save(order);
    }
}

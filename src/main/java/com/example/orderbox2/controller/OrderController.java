package com.example.orderbox2.controller;
import com.example.orderbox2.dto.OrderCreationDto;
import com.example.orderbox2.model.enums.OrderType;
import com.example.orderbox2.model.repository.OrderRepository;
import com.example.orderbox2.service.OrderService;
import com.example.orderbox2.service.imp.LimitOrderService;
import com.example.orderbox2.service.imp.MarketOrderService;
import com.example.orderbox2.service.imp.StopOrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/orders/")
@AllArgsConstructor
public class OrderController {

    private ModelMapper modelMapper;
    private OrderRepository orderRepository;
    private OrderService orderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createOrder(OrderCreationDto orderCreationDto){
        switch (orderCreationDto.getType()) {
            case STOP:
                orderService = new StopOrderService(modelMapper, orderRepository);
                break;
            case LIMIT:
                orderService = new LimitOrderService();
                break;
            case MARKET:
                orderService = new MarketOrderService();
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderService.createOrder(orderCreationDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

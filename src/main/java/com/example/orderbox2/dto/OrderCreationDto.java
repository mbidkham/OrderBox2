package com.example.orderbox2.dto;

import com.example.orderbox2.exception.RestOrderException;
import com.example.orderbox2.model.enums.OrderSide;
import com.example.orderbox2.model.enums.OrderType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderCreationDto {
    public OrderCreationDto(Long price, BigDecimal volume, OrderSide side, OrderType type) {
        this.price = price;
        this.volume = volume;
        this.side = side;
        this.type = type;
    }

    @NotNull
    private Long price;
    @NotNull
    private BigDecimal volume;
    @NotNull
    private OrderSide side;
    private OrderType type;

    public OrderType getType() {
        return type;
    }

    public void validateCreationOrder() throws RestOrderException {
        if (this.price < 10_000){
            throw new RestOrderException();
        }
        // Do some validation on this object
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}

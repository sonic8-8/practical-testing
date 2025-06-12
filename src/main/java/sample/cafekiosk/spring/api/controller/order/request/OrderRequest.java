package sample.cafekiosk.spring.api.controller.order.request;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import sample.cafekiosk.spring.domain.order.OrderStatus;
import sample.cafekiosk.spring.domain.orderproduct.OrderProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderRequest {

    List<String> productNumbers;

    @Builder
    private OrderRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }
}

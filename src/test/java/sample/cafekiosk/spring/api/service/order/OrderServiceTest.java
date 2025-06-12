package sample.cafekiosk.spring.api.service.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.api.controller.order.request.OrderRequest;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.*;
import static sample.cafekiosk.spring.domain.product.ProductType.HANDMADE;

@ActiveProfiles("test")
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("상품 번호를 받아 주문을 생성할 수 있다.")
    @Test
    void test() {
        // given
        Product product1 = createProduct("001", HANDMADE, 1000);
        Product product2 = createProduct("002", HANDMADE, 3000);
        Product product3 = createProduct("003", HANDMADE, 5000);
        productRepository.saveAll(List.of(product1, product2, product3));

        OrderRequest request = OrderRequest.builder()
                .productNumbers(List.of("001", "002"))
                .build();

        // when
        OrderResponse orderResponse = orderService.createOrder(request);

        // then
        assertThat()
    }

    private static Product createProduct(String number, ProductType type, int price) {
        return Product.builder()
                .productNumber(number)
                .type(type)
                .sellingStatus(SELLING)
                .name("아메리카노")
                .price(price)
                .build();
    }
}
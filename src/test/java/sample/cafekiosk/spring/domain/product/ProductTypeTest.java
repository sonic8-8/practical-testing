package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTypeTest {

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType() {
        // given
        ProductType bakery = ProductType.BAKERY;
        ProductType bottle = ProductType.BOTTLE;

        // when
        boolean result = ProductType.containsStockType(bakery);
        boolean result2 = ProductType.containsStockType(bottle);

        // then
        assertThat(result).isTrue();
        assertThat(result2).isTrue();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType2() {
        // given
        ProductType handmade = ProductType.HANDMADE;

        // when
        boolean result = ProductType.containsStockType(handmade);

        // then
        assertThat(result).isFalse();
    }
}
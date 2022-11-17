package com.ono.omg.dto.response;

import com.ono.omg.domain.Product;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderResponseDto {

    @Getter
    @NoArgsConstructor
    public static class CreatedOrdersResponseDto {

        // order
        private Long orderId;
        private Integer orderTotalPrice;
//        private String orderStatus;

        // account
        private String username;

        // product
        private String title;
        private String category;
        private String delivery;
        private Long seller;


        @QueryProjection
        public CreatedOrdersResponseDto(Long orderId, Integer orderTotalPrice, String username, String title, String category, String delivery, Long seller) {
            this.orderId = orderId;
            this.orderTotalPrice = orderTotalPrice;
            this.username = username;
            this.title = title;
            this.category = category;
            this.delivery = delivery;
            this.seller = seller;
        }

        public CreatedOrdersResponseDto(Long orderId, Integer orderTotalPrice, String username, Product product) {
            this.orderId = orderId;
            this.orderTotalPrice = orderTotalPrice;
            this.username = username;
            this.title = product.getTitle();
            this.category = product.getCategory();
            this.delivery = product.getDelivery();
            this.seller = product.getSellerId();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class cancelOrderResponseDto {
        /**
         * 다중 상품인 경우 아래 두 필드는 List에 별도의 Dto로 담김
         */
        private Long productId;
        private String productName;

        private String orderStatus;
    }
}

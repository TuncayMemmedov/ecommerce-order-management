package az.tuncay.ecommerce.mapper;

import az.tuncay.ecommerce.dto.OrderItemRequestDto;
import az.tuncay.ecommerce.dto.OrderItemResponseDto;
import az.tuncay.ecommerce.entity.OrderItem;
import az.tuncay.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItem toEntity(OrderItemRequestDto dto, Product product) {
        return OrderItem.builder()
                .product(product)
                .quantity(dto.getQuantity())
                .build();
    }

    public OrderItemResponseDto toResponse(OrderItem orderItem){
        return OrderItemResponseDto.builder().
                id(orderItem.getId()).
                productId(orderItem.getProduct().getId()).
                productName(orderItem.getProduct().getName()).
                quantity(orderItem.getQuantity()).
                unitPrice(orderItem.getUnitPrice()).
                build();
    }
}

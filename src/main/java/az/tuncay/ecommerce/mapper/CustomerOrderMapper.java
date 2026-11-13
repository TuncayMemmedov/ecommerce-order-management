package az.tuncay.ecommerce.mapper;

import az.tuncay.ecommerce.dto.CustomerOrderRequestDto;
import az.tuncay.ecommerce.dto.CustomerOrderResponseDto;
import az.tuncay.ecommerce.entity.Customer;
import az.tuncay.ecommerce.entity.CustomerOrder;
import az.tuncay.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerOrderMapper {

    public CustomerOrder toEntity(Customer customer, List<OrderItem> orderItems) {
        return CustomerOrder.builder()
                .customer(customer)
                .orderItems(orderItems)
                .build();
    }

    public CustomerOrderResponseDto toResponse(CustomerOrder customerOrder) {
        return CustomerOrderResponseDto.builder()
                .id(customerOrder.getId())
                .totalAmount(customerOrder.getTotalAmount())
                .status(customerOrder.getStatus())
                .createdAt(customerOrder.getCreatedAt())
                .build();
    }
}

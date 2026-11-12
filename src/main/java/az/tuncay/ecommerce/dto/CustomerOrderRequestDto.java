package az.tuncay.ecommerce.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderRequestDto {

    private Long customerId;

    private List<OrderItemRequestDto> orderItems;
}
package az.tuncay.ecommerce.dto;

import az.tuncay.ecommerce.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderResponseDto {

    private Long id;

    private BigDecimal totalAmount;

    private OrderStatus status;

    private LocalDateTime createdAt;
}

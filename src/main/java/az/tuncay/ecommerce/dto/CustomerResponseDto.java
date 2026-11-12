package az.tuncay.ecommerce.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {

    private Long id;

    private String fullName;

    private String email;

    private LocalDateTime createdAt;

}

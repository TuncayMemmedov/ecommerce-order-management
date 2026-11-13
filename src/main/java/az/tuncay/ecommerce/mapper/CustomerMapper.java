package az.tuncay.ecommerce.mapper;

import az.tuncay.ecommerce.dto.CustomerRequestDto;
import az.tuncay.ecommerce.dto.CustomerResponseDto;
import az.tuncay.ecommerce.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDto dto){
        return Customer.builder().
                fullName(dto.getFullName()).
                email(dto.getEmail()).
                build();
    }

    public CustomerResponseDto toResponse(Customer customer){
        return CustomerResponseDto.builder().
                id(customer.getId()).
                fullName(customer.getFullName()).
                email(customer.getEmail()).
                createdAt(customer.getCreatedAt()).
                build();
    }
}

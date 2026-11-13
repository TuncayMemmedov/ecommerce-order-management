package az.tuncay.ecommerce.mapper;

import az.tuncay.ecommerce.dto.ProductRequestDto;
import az.tuncay.ecommerce.dto.ProductResponseDto;
import az.tuncay.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDto dto){
        return Product.builder().
                name(dto.getName()).
                description(dto.getDescription()).
                price(dto.getPrice()).
                stockQuantity(dto.getStockQuantity()).
                build();
    }

    public ProductResponseDto toResponse(Product product){
        return ProductResponseDto.builder().
                id(product.getId()).
                name(product.getName()).
                description(product.getDescription()).
                price(product.getPrice()).
                stockQuantity(product.getStockQuantity()).
                createdAt(product.getCreatedAt()).
                build();
    }
}

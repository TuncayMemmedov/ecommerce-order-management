
package az.tuncay.ecommerce.service;

import az.tuncay.ecommerce.dto.ProductRequestDto;
import az.tuncay.ecommerce.dto.ProductResponseDto;
import az.tuncay.ecommerce.entity.Product;
import az.tuncay.ecommerce.exception.ResourceNotFoundException;
import az.tuncay.ecommerce.mapper.ProductMapper;
import az.tuncay.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private Product getProductEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));
    }

    public ProductResponseDto createProduct(ProductRequestDto dto) {

        Product product = productMapper.toEntity(dto);

        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    public ProductResponseDto getProductById(Long id) {

        Product product = getProductEntityById(id);

        return productMapper.toResponse(product);
    }

    public List<ProductResponseDto> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {

        Product product = getProductEntityById(id);

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    public void deleteProduct(Long id) {

        Product product = getProductEntityById(id);

        productRepository.delete(product);
    }

    public List<ProductResponseDto> getProductsSortedByPrice() {

        return productRepository.findAllByOrderByPriceAsc()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}

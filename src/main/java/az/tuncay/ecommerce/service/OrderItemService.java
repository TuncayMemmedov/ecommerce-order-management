package az.tuncay.ecommerce.service;

import az.tuncay.ecommerce.dto.OrderItemRequestDto;
import az.tuncay.ecommerce.dto.OrderItemResponseDto;
import az.tuncay.ecommerce.entity.CustomerOrder;
import az.tuncay.ecommerce.entity.OrderItem;
import az.tuncay.ecommerce.entity.Product;
import az.tuncay.ecommerce.exception.ResourceNotFoundException;
import az.tuncay.ecommerce.mapper.OrderItemMapper;
import az.tuncay.ecommerce.repository.CustomerOrderRepository;
import az.tuncay.ecommerce.repository.OrderItemRepository;
import az.tuncay.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final CustomerOrderRepository customerOrderRepository;
    private final ProductRepository productRepository;

    public OrderItemResponseDto addOrderItem(Long orderId, OrderItemRequestDto dto) {

        CustomerOrder customerOrder = customerOrderRepository
                .findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        Product product = productRepository
                .findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        OrderItem orderItem = orderItemMapper.toEntity(dto, product);

        orderItem.setOrder(customerOrder);

        orderItem.setUnitPrice(product.getPrice());

        BigDecimal itemTotal = orderItem.getUnitPrice()
                .multiply(BigDecimal.valueOf(orderItem.getQuantity()));

        customerOrder.setTotalAmount(
                customerOrder.getTotalAmount().add(itemTotal)
        );

        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        customerOrderRepository.save(customerOrder);

        return orderItemMapper.toResponse(savedOrderItem);
    }
}

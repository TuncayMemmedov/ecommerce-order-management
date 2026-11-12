package az.tuncay.ecommerce.repository;

import az.tuncay.ecommerce.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}

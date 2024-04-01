package shopify.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopify.shopify.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

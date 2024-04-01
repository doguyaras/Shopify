package shopify.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopify.shopify.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

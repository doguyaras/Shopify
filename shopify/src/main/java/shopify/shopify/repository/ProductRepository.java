package shopify.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopify.shopify.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

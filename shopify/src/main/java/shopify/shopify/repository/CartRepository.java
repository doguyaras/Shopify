package shopify.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopify.shopify.entity.Cart;
import shopify.shopify.entity.Product;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByCustomerId(int customerId);

    Cart findByCustomerIdAndProductId(int customerId, int productId);
}

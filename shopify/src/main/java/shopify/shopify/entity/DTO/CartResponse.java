package shopify.shopify.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shopify.shopify.entity.Customer;
import shopify.shopify.entity.Product;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private Customer customer;
    private List<Product> products;
    private int totalPrice;
}

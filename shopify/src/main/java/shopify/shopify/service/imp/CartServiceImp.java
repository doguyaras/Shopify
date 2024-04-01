package shopify.shopify.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopify.shopify.entity.Cart;
import shopify.shopify.entity.Customer;
import shopify.shopify.entity.DTO.CartDTO;
import shopify.shopify.entity.DTO.CartRequest;
import shopify.shopify.entity.DTO.CartResponse;
import shopify.shopify.entity.Product;
import shopify.shopify.repository.CartRepository;
import shopify.shopify.service.ICartService;
import shopify.shopify.service.ICustomerService;
import shopify.shopify.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements ICartService {

    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IProductService iProductService;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int id) {
        Optional<Cart> result = cartRepository.findById(id);
        if (!result.isPresent()) {
            throw new RuntimeException("Id can not find!: " + id);
        }
        return result.get();
    }

    @Override
    @Transactional
    public void add(CartDTO cartDTO) {

        Cart cart = new Cart();
        cart.setCustomerId(cartDTO.getCustomerid());
        cart.setProductId(cartDTO.getProductid());

        Product product = this.iProductService.findById(cartDTO.getProductid());
        if (product.getStockAmount() > 0) {
            product.setStockAmount(product.getStockAmount() - 1);
            this.iProductService.save(product);
        } else {
            throw new RuntimeException("Stock is not available.");
        }

        this.cartRepository.save(cart);


    }

    @Override
    public void remove(CartDTO cartDTO) {

        Cart cart = this.cartRepository.findByCustomerIdAndProductId(cartDTO.getCustomerid(), cartDTO.getProductid());

        Product product = this.iProductService.findById(cartDTO.getProductid());
        if (product.getStockAmount() > 0) {
            product.setStockAmount(product.getStockAmount() + 1);
            this.iProductService.save(product);
        }

        this.cartRepository.delete(cart);
    }

    @Override
    public CartResponse getResponse(CartRequest cartRequest) {
        Customer customer = this.iCustomerService.findById(cartRequest.getCustomerId());

        List<Cart> carts = this.cartRepository.findByCustomerId(cartRequest.getCustomerId());

        List<Product> products = new ArrayList<>();
        int totalPrice = 0;
        for (Cart cart : carts) {
            Product product = this.iProductService.findById(cart.getProductId());
            products.add(product);
            totalPrice = totalPrice + product.getPrice();
        }

        CartResponse cartResponse = new CartResponse();
        cartResponse.setCustomer(customer);
        cartResponse.setProducts(products);
        cartResponse.setTotalPrice(totalPrice);
        return cartResponse;

    }
}

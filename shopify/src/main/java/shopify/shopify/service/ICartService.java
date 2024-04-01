package shopify.shopify.service;

import shopify.shopify.entity.Cart;
import shopify.shopify.entity.DTO.CartDTO;
import shopify.shopify.entity.DTO.CartRequest;
import shopify.shopify.entity.DTO.CartResponse;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();
    Cart findById(int id);
    void add(CartDTO cartDTO);

    void remove(CartDTO cartDTO);

    CartResponse getResponse(CartRequest cartRequest);
}

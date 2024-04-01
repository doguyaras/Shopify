package shopify.shopify.service;

import shopify.shopify.entity.Order;
import shopify.shopify.entity.Product;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findById(int id);
}

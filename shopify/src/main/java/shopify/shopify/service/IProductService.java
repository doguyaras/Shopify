package shopify.shopify.service;

import shopify.shopify.entity.Customer;
import shopify.shopify.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void add(Product product);
    void delete(int id);
    Product save(Product product);
}

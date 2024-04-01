package shopify.shopify.service;

import shopify.shopify.entity.Customer;
import shopify.shopify.entity.Product;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer findById(int id);
    void add(Customer customer);
}

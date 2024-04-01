package shopify.shopify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shopify.shopify.entity.Customer;
import shopify.shopify.service.ICustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping("/getAllCustomers")
    public List<Customer> findAll() {
        return iCustomerService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Customer customer) {
        iCustomerService.add(customer);
    }

}

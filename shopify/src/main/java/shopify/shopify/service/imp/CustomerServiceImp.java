package shopify.shopify.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopify.shopify.entity.Customer;
import shopify.shopify.entity.Product;
import shopify.shopify.repository.CustomerRepository;
import shopify.shopify.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        if (!result.isPresent()) {
            throw new RuntimeException("Id can not find!: " + id);
        }
        return result.get();
    }

    @Override
    @Transactional
    public void add(Customer customer) {
        customerRepository.save(customer);
    }
}

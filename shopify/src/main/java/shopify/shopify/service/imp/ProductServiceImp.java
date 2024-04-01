package shopify.shopify.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopify.shopify.entity.Product;
import shopify.shopify.repository.ProductRepository;
import shopify.shopify.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        if (!result.isPresent()) {
            throw new RuntimeException("Id can not find!: " + id);
        }
        return result.get();
    }

    @Override
    @Transactional
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }
}

package shopify.shopify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shopify.shopify.entity.Product;
import shopify.shopify.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "Deleted user id: " + id;
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }
}

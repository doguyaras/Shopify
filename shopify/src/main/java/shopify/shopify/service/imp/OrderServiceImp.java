package shopify.shopify.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopify.shopify.entity.Order;
import shopify.shopify.entity.Product;
import shopify.shopify.repository.OrderRepository;
import shopify.shopify.service.IOrderService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements IOrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        Optional<Order> result = orderRepository.findById(id);
        if (!result.isPresent()) {
            throw new RuntimeException("Id can not find!: " + id);
        }
        return result.get();
    }
}

package pelagustravel.travelo.service.productDeliveryService.product;

import pelagustravel.travelo.model.productDeliveryService.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product>findById(long id);
    void save(Product product);
}

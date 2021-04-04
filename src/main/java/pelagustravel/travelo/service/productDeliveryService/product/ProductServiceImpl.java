package pelagustravel.travelo.service.productDeliveryService.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.productDeliveryService.Product;
import pelagustravel.travelo.repository.productDeliveryRepitory.ProductRepository;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

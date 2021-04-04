package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.ProductDTO;
import pelagustravel.travelo.exceptions.Product.ProductNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.productDeliveryService.Product;
import pelagustravel.travelo.service.productDeliveryService.product.ProductService;

import java.util.Optional;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @Autowired
  private EntityToDTOConverter entityToDTOConverter;

  @GetMapping("/product/{id}")
  public ProductDTO getProductById(@PathVariable long id) throws ProductNotFoundException {
      Optional<Product>product=productService.findById(id);
      if(product.isPresent()) {
          return entityToDTOConverter.productToProductDTO(product.get());
      }else {
          throw new ProductNotFoundException("Product not found");
      }
  }
}

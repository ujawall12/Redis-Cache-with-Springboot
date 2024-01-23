package com.springnboot.redisimpl.service;

import com.springnboot.redisimpl.model.Product;
import com.springnboot.redisimpl.repository.ProductRepository;
import com.springnboot.redisimpl.utils.ProductUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductUtil productUtil;

    public Product getProduct(Long id) {
        return productRepository.getProductById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Product createProduct(Product product) {
        productUtil.updateProduct(product.getId(), product);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productUtil.deleteProduct(id);
        productRepository.deleteById(id);
    }
    public void deleteProductFromCache(Long id) {
        productUtil.deleteProduct(id);
    }
}

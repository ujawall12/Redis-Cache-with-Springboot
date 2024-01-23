package com.springnboot.redisimpl.service;

import com.springnboot.redisimpl.model.Product;
import com.springnboot.redisimpl.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.getProductById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}

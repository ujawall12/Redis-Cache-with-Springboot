package com.springnboot.redisimpl.utils;

import com.springnboot.redisimpl.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductUtil {

    @CachePut(value = "product", key = "#id")
    public Product updateProduct(Long id, Product data) {
        log.info("Updating product with id: " + id);
        return data;
    }

    @CacheEvict(value = "product", key = "#id")
    public Void deleteProduct(Long id) {
        log.info("Deleting product with id: " + id);
        return null;
    }
}

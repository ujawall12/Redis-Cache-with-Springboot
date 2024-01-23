package com.springnboot.redisimpl.repository;

import com.springnboot.redisimpl.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Cacheable(value = "product", key = "#id", unless = "#result == null")
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    public Product getProductById(Long id);

    public Product findProductByName(String name);
}

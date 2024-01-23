package com.springnboot.redisimpl.controller;

import com.springnboot.redisimpl.model.Product;
import com.springnboot.redisimpl.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<Product> getProduct(@RequestParam Long id) {
        if (Objects.isNull(productService.getProduct(id))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/getByName")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        if (Objects.isNull(productService.getProductByName(name))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
        productService.deleteProductFromCache(id);
        return ResponseEntity.ok().build();
    }
}

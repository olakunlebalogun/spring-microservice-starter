package com.olakunle.productservice.service;

import com.olakunle.productservice.dto.ProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> createProduct(ProductRequest request);
    ResponseEntity<?> getAllProducts();
}

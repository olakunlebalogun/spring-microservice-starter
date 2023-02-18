package com.olakunle.sixhour.product.service;

import com.olakunle.sixhour.product.dto.ProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> createProduct(ProductRequest request);
    ResponseEntity<?> getAllProducts();
}

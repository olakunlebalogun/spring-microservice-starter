package com.olakunle.productservice.implementation;


import com.olakunle.productservice.dto.ProductRequest;
import com.olakunle.productservice.dto.ProductResponse;
import com.olakunle.productservice.entity.Product;
import com.olakunle.productservice.repository.ProductRepository;
import com.olakunle.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public ResponseEntity<?> createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        productRepository.save(product);
        return ResponseEntity.ok().body("Product successfully added");
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        List<ProductResponse> productResponses = productRepository.findAll().stream().map(this::productResponseMapper).collect(Collectors.toList());
        return ResponseEntity.ok().body(productResponses);
    }

    private ProductResponse productResponseMapper (Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}

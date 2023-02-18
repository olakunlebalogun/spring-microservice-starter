package com.olakunle.sixhour.product.controller;

import com.olakunle.sixhour.product.dto.ProductRequest;
import com.olakunle.sixhour.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.olakunle.sixhour.product.utils.ProductURL.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping(ADD)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addProduct (@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping(FIND_ALL)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllProducts () {
        return productService.getAllProducts();
    }
}

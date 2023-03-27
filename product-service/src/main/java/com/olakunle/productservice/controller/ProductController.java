package com.olakunle.productservice.controller;

import com.olakunle.productservice.dto.ProductRequest;
import com.olakunle.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.olakunle.productservice.utils.ProductURL.*;


//@RestController
@Controller
@ResponseBody
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

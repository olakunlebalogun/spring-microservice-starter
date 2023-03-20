package com.olakunle.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olakunle.productservice.dto.ProductRequest;
import com.olakunle.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class ProductServiceApplicationTests {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @DynamicPropertySource
    static void setProperties (DynamicPropertyRegistry dynamicPropertyRegistry) {
//        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", () -> mongoDBContainer.getReplicaSetUrl()); // The second parameter requires a supplier, There are two ways to it this and the commented line above.

    }





    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();
        String productRequestString = objectMapper.writeValueAsString(productRequest);

        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestString))
                .andExpect(status().isOk());

        assertEquals(1, productRepository.findAll().size());
    }

    @Test
    void shouldGetAllProduct () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/v1/products"))
                .andExpect(status().isOk());
        assertNotNull(productRepository.findAll().size());
        assertEquals(0, productRepository.findAll().size());
    }


    private ProductRequest getProductRequest () {
        return ProductRequest.builder()
                .name("Chessboard")
                .description("black-brown 15-inches chessboard")
                .price(BigDecimal.valueOf(5000))
                .build();
    }


}

package com.olakunle.sixhour.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
@Document
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
<<<<<<< HEAD
    @Column(nullable = false, precision = 10 )
=======
    @Column(nullable = false, precision = 10)
>>>>>>> 2cb0402 (changes made on this branch)
    @Positive
    private BigDecimal price;
}

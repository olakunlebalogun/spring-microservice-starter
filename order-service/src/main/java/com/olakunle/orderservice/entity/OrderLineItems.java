package com.olakunle.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "order_line_item")
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    // Test: Uncomment the next 3 lines if it does not work.
    //@ManyToOne
    // @JoinColumn(name = "order_id", referencedColumnName = "id") // Uncomment this if it does not work
    //private Order order;


}

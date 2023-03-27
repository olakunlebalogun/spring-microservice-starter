package com.olakunle.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "item_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL) // Test: Testing what the teacher outcome will look like
    // Test: Add this to the @OneToMany annotation above if it does not work:  mappedBy = "order" , checkout the other side of it
    private List<OrderLineItems> orderLineItemsList;
}

package com.olakunle.orderservice.implementation;

import com.olakunle.orderservice.dto.OrderLineItemDTO;
import com.olakunle.orderservice.dto.OrderRequest;
import com.olakunle.orderservice.entity.Order;
import com.olakunle.orderservice.entity.OrderLineItems;
import com.olakunle.orderservice.repository.OrderRepository;
import com.olakunle.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineList().stream().map(this::mapToOrderLineItemsDTO).toList();
        order.setOrderLineItemsList(orderLineItemsList);

        orderRepository.save(order);
    }

    private OrderLineItems mapToOrderLineItemsDTO(OrderLineItemDTO orderLine) {
            OrderLineItems orderLineItems = new OrderLineItems();
            orderLineItems.setQuantity(orderLine.getQuantity());
            orderLineItems.setPrice(orderLine.getPrice());
            orderLineItems.setSkuCode(orderLine.getSkuCode());

            return orderLineItems;
    }
}

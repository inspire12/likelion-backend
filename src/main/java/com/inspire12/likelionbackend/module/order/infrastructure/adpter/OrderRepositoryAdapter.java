package com.inspire12.likelionbackend.module.order.infrastructure.adpter;

import com.inspire12.likelionbackend.exception.OrderNotExistException;
import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.OrderMemoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderMemoryRepository orderMemoryRepository;
    private final StoreStatusPort statusPort;

    public OrderRepositoryAdapter(StoreStatusPort statusPort) {
        this.orderMemoryRepository = new OrderMemoryRepository() {
            private final Map<UUID, Order> orders = new HashMap<>();
            @Override
            public Order findByOrderNumber(UUID uuid) {
                return orders.get(uuid);
            }

            @Override
            public Order save(Order order) {
                orders.put(order.getOrderNumber(), order);
                return order;
            }
        };

        this.statusPort = statusPort;
    }

    @Override
    public Order getOrderById(Long orderId) {
        if (statusPort.getStoreOpenStatus(orderId)) {
//            return OrderFactory.createOrder(orderId);
        }
        throw new OrderNotExistException();
    }


    @Override
    public Order getOrderByOrderNumber(String orderNumber) {
        return orderMemoryRepository.findByOrderNumber(UUID.fromString(orderNumber));
    }

    @Override
    public Order save(Order order) {
        return orderMemoryRepository.save(order);
    }
}

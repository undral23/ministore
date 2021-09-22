package edu.miu.waa.ministore.service;

import org.springframework.web.bind.annotation.PathVariable;

import edu.miu.waa.ministore.domain.Buyer;
import edu.miu.waa.ministore.domain.LineItem;
import edu.miu.waa.ministore.domain.Order;
import edu.miu.waa.ministore.domain.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderService {
    public List<LineItem> getOrderLineItemsByOrderId(long id);
    public Order getOrderById(long id);

    public void save(Order order);
    public Order deliveredOrder(String userName,long oId);
}

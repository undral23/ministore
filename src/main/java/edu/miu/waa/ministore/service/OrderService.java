package edu.miu.waa.ministore.service;

import java.util.List;

import edu.miu.waa.ministore.domain.LineItem;
import edu.miu.waa.ministore.domain.Order;

public interface OrderService {
	public List<LineItem> getOrderLineItemsByOrderId(long id);

	public Order getOrderById(long id);

	public void save(Order order);

	public Order deliveredOrder(String userName, long oId);

	public List<Order> findAllOrdersByBuyerId(long id);
}

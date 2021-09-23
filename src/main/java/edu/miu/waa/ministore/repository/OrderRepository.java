package edu.miu.waa.ministore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import edu.miu.waa.ministore.domain.LineItem;
import edu.miu.waa.ministore.domain.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	@Query(value = "select o.lineItems from order o where o.id=:orderId")
	public List<LineItem> findAllLineItemsByOrderId(long orderId);

	@Query(value = "select o from order o where o.buyer.id=:buyerId")
	public List<Order> findAllOrdersByBuyerId(long buyerId);

	public Order findOrderById(long id);

}

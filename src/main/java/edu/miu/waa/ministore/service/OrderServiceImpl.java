package edu.miu.waa.ministore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.miu.waa.ministore.domain.Buyer;
import edu.miu.waa.ministore.domain.LineItem;
import edu.miu.waa.ministore.domain.Order;
import edu.miu.waa.ministore.domain.OrderStatus;
import edu.miu.waa.ministore.repository.BuyerRepository;
import edu.miu.waa.ministore.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BuyerRepository buyerRepository;


    @Override
    public List<LineItem> getOrderLineItemsByOrderId(long id) {
        return orderRepository.findAllLineItemsByOrderId(id);
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order deliveredOrder(String userName, long oId) {

            Buyer buyer =buyerRepository.findBuyerByUsername(userName);
            List<Long> lOID= buyer.getOrders().stream().map(o->o.getId()).collect(Collectors.toList());
            if( lOID.contains(oId)) {
                Order order=orderRepository.findOrderById(oId);
                order.setOrderStatus(OrderStatus.DELIVERED.getOrderStatus());
                orderRepository.save(order);
                buyerRepository.save(buyer);
                return order;
            }
            return null;

    }
}

package edu.miu.waa.ministore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.waa.ministore.domain.Order;
import edu.miu.waa.ministore.domain.OrderStatus;
import edu.miu.waa.ministore.domain.ProductStatus;
import edu.miu.waa.ministore.domain.Seller;
import edu.miu.waa.ministore.repository.OrderRepository;
import edu.miu.waa.ministore.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderService orderService;

	@Autowired
	SellerService sellerService;

	public Seller getSellerByEmail(String email) {
		return sellerRepository.findSellerByEmail(email);
	};

	@Override
	public Seller getSellerById(long id) {

		return sellerRepository.findSellerById(id);
	}

	@Override
	public Seller getSellerByUserName(String userName) {

		return sellerRepository.findSellerBySUserName(userName);
	}

	@Override
	public Seller makeItApprovedOrRejected(Long id, String status) {
		try {
			Seller seller = sellerRepository.findSellerById(id);
			if (seller != null) {
				if (status.equals("Approved")) {
					seller.setStatus(ProductStatus.APPROVED.getProductStatus());
					return sellerRepository.save(seller);

				}
				if (status.equals("Rejected")) {
					seller.setStatus(ProductStatus.REJECTED.getProductStatus());
					return sellerRepository.save(seller);

				}
				return null;
			}
			return null;
		} catch (IllegalArgumentException e) {
			System.out.println("STATUS ERROR: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Order> getOrdersBySellerById(long sId) {

		List<Order> orders = sellerRepository.getOrdersBySellerBySId(sId).stream()
				.map(o -> orderRepository.findById(o).get()).collect(Collectors.toList());
		return orders;

	}

	@Override
	public List<Long> getOrderIdsBySellerById(long sId) {
		return sellerRepository.getOrdersBySellerBySId(sId);
	}

	@Override
	public List<Seller> getAllSellers() {
		return (List<Seller>) sellerRepository.findAll();
	}

	@Override
	public void addSeller(Seller seller) {
		sellerRepository.save(seller);
	}

	@Override
	public void save(Seller seller) {
		sellerRepository.save(seller);
	}

	@Override
	public Order shipSellerOrder(String userName, long oId) {
		Seller seller = sellerRepository.findSellerByUsername(userName);
		List<Long> lOID = this.getOrderIdsBySellerById(seller.getId());
		if (lOID.contains(oId)) {
			Order order = orderService.getOrderById(oId);
			order.setOrderStatus(OrderStatus.SHIPPED.getOrderStatus());
			orderService.save(order);
			sellerService.save(seller);
			return order;
		}
		return null;
	}

	@Override
	public Order cancelSellerOrder(String userName, long oId) {
		Seller seller = sellerService.getSellerByUserName(userName);
		List<Long> lOID = sellerService.getOrderIdsBySellerById(seller.getId());
		if (lOID.contains(oId)) {
			Order order = orderService.getOrderById(oId);
			if (order.getOrderStatus() != OrderStatus.SHIPPED.getOrderStatus())
				order.setOrderStatus(OrderStatus.CANCELLED.getOrderStatus());
			orderService.save(order);
			return order;
		}
		return null;
	}

	@Override
	public Order getOrderByIdForSeller(String userName, long oId) {
		if (getOrderIdsBySellerById(getSellerByUserName(userName).getId()).contains(oId)) {
			Order order = orderService.getOrderById(oId);
			return order;
		}
		return null;

	}

}

package edu.miu.waa.ministore.service;

import java.util.List;

import edu.miu.waa.ministore.domain.Order;
import edu.miu.waa.ministore.domain.Seller;

public interface SellerService {
	public Seller getSellerById(long id);

	public Seller getSellerByUserName(String userName);

	public List<Long> getOrderIdsBySellerById(long id);

	public Seller makeItApprovedOrRejected(String userName, String status);

	public List<Order> getOrdersBySellerById(long id);

	public List<Seller> getAllSellers();

	public void addSeller(Seller seller);

	public void save(Seller seller);

	public Order shipSellerOrder(String userName, long oId);

	public Order cancelSellerOrder(String userName, long oId);

	public Order getOrderByIdForSeller(String userName, long oId);
}

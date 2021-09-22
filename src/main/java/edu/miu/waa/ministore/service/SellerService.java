package edu.miu.waa.ministore.service;

import org.springframework.data.repository.query.Param;

import edu.miu.waa.ministore.domain.Address;
import edu.miu.waa.ministore.domain.Order;
import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.Seller;

import java.util.List;


public interface SellerService {
    public Seller getSellerBySId(long id);
    public Seller getSellerByUserName(String userName);
    public List<Long> getOrderIdsBySellerBySId(long sId);

    public Seller makeItApprovedOrRejected(String userName, String status);
    public List<Order> getOrdersBySellerBySId( long sId);

    public List<Seller> getAllSellers();

    public void addSeller(Seller seller);

    public void save(Seller seller);

    public Order shipSellerOrder(String userName, long oId);

    public Order cancelSellerOrder(String userName, long oId);

    public Order getOrderByIdForSeller(String userName, long oId);
}

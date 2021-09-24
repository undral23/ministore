package edu.miu.waa.ministore.repository;

import edu.miu.waa.ministore.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.waa.ministore.domain.Address;
import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.Seller;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {

    @Query("select s from Seller s where s.user.username=:userName")
    public Seller findSellerByUsername(String userName);

    @Query("select s from Seller s where s.user.email=:email")
    public Seller findSellerByEmail(@Param("email") String email);
//
//    @Query("select s from Seller  s where s.sId=:sId")
    public Seller findSellerById(@Param("id") long id);

    @Query(value = "SELECT DISTINCT ord FROM order ord INNER JOIN FETCH ord.lineItems li where li.product.seller.id = :sId")
    public List<Order> getOrdersBySellerBySId(@Param("sId") long sId);

    @Query("select s from Seller s where s.user.username=:userName")
    public Seller findSellerBySUserName(String userName);

    @Query(value = "select seller.products from Seller seller where seller.user.username=:sellerUserName")
    public List<Product> findAllProductBySellerUserName(String sellerUserName, Pageable pageable);
}

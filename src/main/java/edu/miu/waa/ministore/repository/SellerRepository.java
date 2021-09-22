package edu.miu.waa.ministore.repository;

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

    @Query("select s from Seller  s where s.sId=:sId")
    public Seller findSellerBySId(@Param("sId") long sId);

    @Query(value = "SELECT DISTINCT ord_id FROM maskm_db.ord_line_items where line_items_id in " +
            "(SELECT li.id FROM maskm_db.line_item li where product_id  in " +
            "(SELECT products_id FROM maskm_db.seller_products where seller_s_id=:sId ))",nativeQuery = true)
    public List<Long> getOrdersBySellerBySId(@Param("sId") long sId);

    @Query("select s from Seller s where s.user.username=:userName")
    public Seller findSellerBySUserName(String userName);

    @Query(value = "select seller.products from Seller seller where seller.user.username=:sellerUserName")
    public List<Product> findAllProductBySellerUserName(String sellerUserName, Pageable pageable);
}

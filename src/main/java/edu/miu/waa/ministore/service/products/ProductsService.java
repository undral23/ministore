package edu.miu.waa.ministore.service.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.Review;

public interface ProductsService {

//	public Product addProduct(Product product, long cat_id, String userName);

	public Product addProduct(Product product);

	public Optional<Product> getProductById(long id);

	public List<Product> getAllProducts(Pageable pageable);

	public List<Product> getAllProductsForOneSeller(Pageable pageable, String SellerUserName);

	public boolean isExistById(long id);

	public String deleteById(long id);

	public Product editProduct(long id, Product product);

	public Product makeItApprovedOrRejected(long id, String status);

//    public Product makeItFeatured(long id,boolean featured);
	public void deleteProduct(long product_id);

	public Product addReviewToProduct(long id, Review review);

	public List<Review> getAllReviewsForProduct(long id);

	public List<Product> getAllProductWithPagingAndSorting(Pageable pageable);

	public Review approveReview(long product_id, long review_id, String approved);

	public List<Product> getAllProductsWithCat(Pageable pageable, long cat_ID);

	public List<Review> getAllReviewsWithoutApproval();
}

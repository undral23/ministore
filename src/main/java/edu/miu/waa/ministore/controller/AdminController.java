package edu.miu.waa.ministore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.waa.ministore.domain.Admin;
import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.ProductCategory;
import edu.miu.waa.ministore.domain.Review;
import edu.miu.waa.ministore.domain.Seller;
import edu.miu.waa.ministore.service.SellerService;
import edu.miu.waa.ministore.service.admin.AdminService;
import edu.miu.waa.ministore.service.categories.CategoryService;
import edu.miu.waa.ministore.service.products.ProductsService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = { "*" })
public class AdminController {

	@Autowired
	ProductsService productsService;
	@Autowired
	SellerService sellerService;

	@Autowired
	AdminService adminService;

	@GetMapping("{admin_userName}/profile")
	public Admin getAdminProfile(@PathVariable String admin_userName) {
		return adminService.getAdminProfile(admin_userName);
	}

	@GetMapping("/products/{id}")
	public Product approveProduct(@RequestParam("approved") boolean approved, @PathVariable long id) {
		if (approved)
			return productsService.makeItApprovedOrRejected(id, "Approved");
		else
			return productsService.makeItApprovedOrRejected(id, "Rejected");
	}

	@GetMapping("/seller/{userName}")
	public Seller approveSeller(@RequestParam("approved") boolean approved, @PathVariable String userName) {
		if (approved)
			return sellerService.makeItApprovedOrRejected(userName, "Approved");
		else
			return sellerService.makeItApprovedOrRejected(userName, "Rejected");
	}

//	@GetMapping("/products/{id}/featured")
//	public Product makeProductFeatured(@RequestParam("get") boolean featured, @PathVariable long id) {
//		return productsService.makeItFeatured(id, featured);
//	}

	@GetMapping("/products/{product_id}/reviews/{review_id}")
	public Review approveReview(@PathVariable long product_id, @PathVariable long review_id,
			@RequestParam("approved") boolean approved) {
		if (approved)
			return productsService.approveReview(product_id, review_id, "Approved");
		else
			return productsService.approveReview(product_id, review_id, "Rejected");
	}

	@GetMapping("/reviews")
	public List<Review> getAllReviewWithoutApproval() {
		return productsService.getAllReviewsWithoutApproval();
	}

	@Autowired
	CategoryService categoryService;

	@PostMapping("/cats")
	public ProductCategory addCats(@RequestBody ProductCategory productCategory) {
		return categoryService.addCategory(productCategory);
	}

	@PutMapping("/cats/{id}")
	public ProductCategory editCat(@RequestBody ProductCategory productCategory, @PathVariable long id) {
		return categoryService.editCategory(id, productCategory);
	}

	@DeleteMapping("/cats/{id}")
	public String deleteCat(@PathVariable long id) {
		return categoryService.deleteCategory(id);
	}

	@GetMapping("/sellers")
	public List<Seller> getAllSellers() {
		return sellerService.getAllSellers();
	}

	@GetMapping("/sellers/{id}")
	public Seller getOneSeller(@PathVariable int id) {

		return sellerService.getSellerById(id);
	}
//    @DeleteMapping("products/{productId}")
//    public boolean deleteProduct(@PathVariable long id){
//        return productsService.deleteProduct(id);
//    }
}

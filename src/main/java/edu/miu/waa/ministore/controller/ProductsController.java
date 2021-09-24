package edu.miu.waa.ministore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.Review;
import edu.miu.waa.ministore.service.SellerService;
import edu.miu.waa.ministore.service.MyUserDetails.LoginUserDetails;
import edu.miu.waa.ministore.service.products.ProductsService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductsController {

	@Autowired
	ProductsService productsService;

	@Autowired
	SellerService sellerService;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		LoginUserDetails userDetails = (LoginUserDetails) auth.getPrincipal();

		product.setSeller(sellerService.getSellerByUserName(userDetails.getUsername()));
		return productsService.addProduct(product);
	}

	@GetMapping()
	public List<Product> getAllProductsPaging(@RequestParam(required = false, name = "page") String page,
			@RequestParam(required = false, name = "limit") String limit,
			@RequestParam(required = false, name = "cat") String cat_id,
			@RequestParam(required = false, name = "userName") String sellerUserName) {
		if (page != null && limit != null) {
			if (cat_id != null)
				return productsService.getAllProductsWithCat(
						PageRequest.of(Integer.parseInt(page) - 1, Integer.parseInt(limit)), Integer.parseInt(cat_id));
			else if (sellerUserName != null)
				return productsService.getAllProductsForOneSeller(
						PageRequest.of(Integer.parseInt(page) - 1, Integer.parseInt(limit)), sellerUserName);
			else
				return productsService.getAllProductWithPagingAndSorting(
						PageRequest.of(Integer.parseInt(page) - 1, Integer.parseInt(limit)));

		} else if (sellerUserName != null)
			return productsService.getAllProductsForOneSeller(Pageable.unpaged(), sellerUserName);
		else if (cat_id != null)
			return productsService.getAllProductsWithCat(Pageable.unpaged(), Integer.parseInt(cat_id));

		else
			return productsService.getAllProducts(Pageable.unpaged());
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable long id) {
		productsService.deleteProduct(id);
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable long id) {
		return productsService.getProductById(id).orElse(null);
	}

	@PostMapping("/{id}/reviews")
	public Product addReview(@RequestBody Review review, @PathVariable long id) {
		return productsService.addReviewToProduct(id, review);
	}

	@GetMapping("/{id}/reviews")
	public List<Review> getAllReviewsForProduct(@PathVariable long id) {
		return productsService.getAllReviewsForProduct(id);
	}

	@PutMapping("/{id}")
	public Product editProduct(@PathVariable long id, @RequestBody Product product) {
		return productsService.editProduct(id, product);
	}

}

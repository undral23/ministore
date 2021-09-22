package edu.miu.waa.ministore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.ProductCategory;
import edu.miu.waa.ministore.service.categories.CategoryService;
import edu.miu.waa.ministore.service.products.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/cats")
@CrossOrigin(origins = {"*"})
public class CatsController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductsService poProductsService;

    @GetMapping()
    public List<ProductCategory> getAllCats(){
        return categoryService.getAllCats();
    }
    @GetMapping("{cat_id}")
    public ProductCategory getOneCat(@PathVariable long cat_id){
        return categoryService.getOneCat(cat_id).orElse(null);
    }


//    @GetMapping("/cats/{id}")
//    public List<ProductSubCategory> getAllSubCats(@PathVariable long id){
//        return categoryService.getAllSubCats(id);
//    }
}

package edu.miu.waa.ministore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import edu.miu.waa.ministore.domain.ProductCategory;
import edu.miu.waa.ministore.domain.Seller;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private boolean featured=false;

    private String title;

    private String description;

//    private List<Image> images;

    private double rating;
    private String status;
    private double price;
    private LocalDate createdOn;
    private ProductCategory productCategory;
    private Seller seller;


}

package edu.miu.waa.ministore.dto;

import edu.miu.waa.ministore.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDTO {

    private double stars;
    private String comment;
    private Product product;
    private String status;
}

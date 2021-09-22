package edu.miu.waa.ministore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import edu.miu.waa.ministore.domain.Product;

@Getter
@Setter
public class LineItemDTO {

    private int quantity;
    private double price;

    private long productId;
}

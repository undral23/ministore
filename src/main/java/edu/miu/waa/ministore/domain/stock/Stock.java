package edu.miu.waa.ministore.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import edu.miu.waa.ministore.domain.Product;
import edu.miu.waa.ministore.domain.Seller;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Stock {

    @Id
    @GeneratedValue
    long id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SELLER_ID")
    private Seller seller;

    @Digits(integer = 5,fraction = 0)
    private int quantity;
}

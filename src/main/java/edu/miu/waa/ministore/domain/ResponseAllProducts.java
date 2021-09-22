package edu.miu.waa.ministore.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseAllProducts extends Response{

    private List<Product> products;
}

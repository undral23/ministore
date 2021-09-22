package edu.miu.waa.ministore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import edu.miu.waa.ministore.domain.LineItem;
@Getter
@Setter
public class OrderDTO {
    private Date createdOn;
    private double price;
    List<LineItemDTO> lineItemsDTO;

}

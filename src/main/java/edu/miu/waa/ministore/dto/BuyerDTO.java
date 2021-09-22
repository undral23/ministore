package edu.miu.waa.ministore.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import edu.miu.waa.ministore.domain.*;

@Getter
@Setter
public class BuyerDTO {

    long points;
    List<Order> orders;
    User user;
    Address shippingAddress;
    Address billingAddress;
    List<PaymentMethod> paymentMethods;
    List<Seller> sellersFollowed;
}

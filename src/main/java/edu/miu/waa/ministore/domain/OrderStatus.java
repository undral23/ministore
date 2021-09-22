package edu.miu.waa.ministore.domain;

public enum OrderStatus {
    SHIPPED("Shipped"),
    RETURNED("Returned"),
    ONTHEWAY("On the way"),
    CANCELLED("Cancelled"),
    DELIVERED("Delivered"),
    PENDING("Pending");


    private String orderStatus;

    OrderStatus(String status){this.orderStatus=status;}

    public String getOrderStatus(){
        return this.orderStatus;
    }
}

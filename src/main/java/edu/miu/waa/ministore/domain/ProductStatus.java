package edu.miu.waa.ministore.domain;

public enum ProductStatus {
    APPROVED("Approved"),
    REJECTED("Rejected"),
    PENDING("Pending");

    private String productStatus;

    ProductStatus(String status){this.productStatus=status;}

    public String getProductStatus(){
        return this.productStatus;
    }
}

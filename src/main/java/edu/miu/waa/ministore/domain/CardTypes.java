package edu.miu.waa.ministore.domain;

public enum CardTypes {
    Visa("Visa"),
    MasterCard("MasterCard"),
    Discoverer("Discoverer");

    private String CardType;

    CardTypes(String status){this.CardType=status;}

    public String getCardType(){
        return this.CardType;
    }
}

package main.java.store.servicePaymentStrategy;

import java.math.BigDecimal;

public class Card implements PaymentMethod {

    private  int id;
    private final String nameOnCard;
    private final String number;
    private final String cvv;
    private final String expirationDate;

    public Card(String nameOnCard, String number, String cvv, String expirationDate) {
        this.nameOnCard = nameOnCard;
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void pay(BigDecimal money) {
        System.out.println("Payed " + money + " using " + toString() + "\n");
    }

    @Override
    public String toString() {
        return "Card:" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ';';
    }
}

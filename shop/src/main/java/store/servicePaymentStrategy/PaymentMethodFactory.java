package main.java.store.servicePaymentStrategy;

import main.java.personalData.Customer;

public class PaymentMethodFactory {

    //оплата по даних які є зареєсторвані а сайті
    public static PaymentMethod getPaymentMethod(Customer customer){
        return payByCreditCard(customer);
    }

    //оплата готівою
    public static PaymentMethod getPaymentMethod(){
        return payByCash();
    }

    //оплата незареєсторваного коритсувача по редитній картці
    public static PaymentMethod getPaymentMethod(Card card){
        return payByCreditCard(card);
    }

    private static Card payByCreditCard(Customer customer){
        return new Card(customer.getCard().getNameOnCard(),
                customer.getCard().getNumber(),
                customer.getCard().getCvv(),
                customer.getCard().getExpirationDate());
    }

    private static Card payByCreditCard(Card card){
        return new Card(card.getNameOnCard(),
                card.getNumber(),
                card.getCvv(),
                card.getExpirationDate());
    }

    private static Cash payByCash(){
        return new Cash();
    }

}

package main.java.store.servicePayment;

import main.java.personalData.Customer;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(Customer customer){
        return payByCreditCard(customer);
    }
    public static PaymentMethod getPaymentMethod(){
        return payByCash();
    }
    public static PaymentMethod getPaymentMethod(Card card){
        return payByCreditCard(card);
    }


    public static Card payByCreditCard(Customer customer){
        return new Card(customer.getCard().getNameOnCard(),
                customer.getCard().getNumber(),
                customer.getCard().getCvv(),
                customer.getCard().getExpirationDate());
    }

    public static Card payByCreditCard(Card card){
        return new Card(card.getNameOnCard(),
                card.getNumber(),
                card.getCvv(),
                card.getExpirationDate());
    }

    public static Cash payByCash(){
        return new Cash();
    }

}

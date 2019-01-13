package main.java;

import main.java.goods.Flower;
import main.java.goods.Goods;
import main.java.personalData.Customer;
import main.java.store.OnlineStore;
import main.java.store.servicePayment.Card;
import main.java.store.servicePayment.PaymentMethodFactory;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        OnlineStore onlineStore = new OnlineStore("rozetka","www.rozetka.com");

        Customer customer = onlineStore.singIn("Ivan","1234");

        System.out.println(customer + "\n");

        onlineStore.createBill().addLineItem(new Goods(1,new Flower(1,"sad",new BigDecimal(502.0))))
                                    .addLineItem(new Goods(2,new Flower(2,"sdfd",new BigDecimal(500.0))))
                                        .pay(PaymentMethodFactory.getPaymentMethod(customer));

        onlineStore.createBill().addLineItem(new Goods(3,new Flower(3,"sad",new BigDecimal(5005.0))))
                                    .addLineItem(new Goods(4,new Flower(4,"sdfd",new BigDecimal(5000.0))))
                                        .pay(PaymentMethodFactory.getPaymentMethod(new Card("John Doe", "4111111111111111", "123", "01/22")));

    }
}

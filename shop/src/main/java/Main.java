package main.java;

import main.java.goods.BunchOfFlowers;
import main.java.goods.Flower;
import main.java.goods.Goods;
import main.java.goods.Product;
import main.java.personalData.Customer;
import main.java.serviceDecorator.MakeBouquet;
import main.java.serviceDecorator.PutInPot;
import main.java.store.OnlineStore;
import main.java.store.servicePaymentStrategy.Card;
import main.java.store.servicePaymentStrategy.PaymentMethodFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OnlineStore onlineStore = new OnlineStore("rozetka","www.rozetka.com");

        Customer customer = onlineStore.singIn("Ivan","1234");

        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Flower(1,"rose",new BigDecimal(100.0)));
        flowerList.add(new Flower(2,"rose",new BigDecimal(100.0)));
        flowerList.add(new Flower(3,"rose",new BigDecimal(100.0)));

        Product bunchOfFlowers = new BunchOfFlowers(1, "bouquet",flowerList);

        onlineStore.setGoods(bunchOfFlowers,5);

        bunchOfFlowers = new MakeBouquet(bunchOfFlowers).done();
        bunchOfFlowers = new PutInPot(bunchOfFlowers).done();

        onlineStore.createBill().addLineItem(new Goods(1,bunchOfFlowers))
                                        .pay(PaymentMethodFactory.getPaymentMethod(customer));

        onlineStore.createBill().addLineItem(new Goods(4,new Flower(3,"sad",new BigDecimal(5005.0))))
                                    .addLineItem(new Goods(5,new Flower(4,"sdfd",new BigDecimal(5000.0))))
                                        .pay(PaymentMethodFactory.getPaymentMethod(new Card("John Doe", "4111111111111111", "123", "01/22")));

    }
}

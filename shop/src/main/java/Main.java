import goods.Flower;
import goods.Goods;
import personalData.Customer;
import store.OnlineStore;
import store.servicePayment.Card;
import store.servicePayment.PaymentMethodFactory;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        OnlineStore onlineStore = new OnlineStore("rozetka","www.rozetka.com");

        Customer customer = onlineStore.singIn("Ivan","1234");

        onlineStore.createBill().addLineItem(new Goods(1,new Flower(1,"sad",new BigDecimal(120.0))))
                                    .addLineItem(new Goods(2,new Flower(2,"sdfd",new BigDecimal(140.0))))
                                        .pay(PaymentMethodFactory.getPaymentMethod(customer));

        onlineStore.createBill().addLineItem(new Goods(3,new Flower(3,"sad",new BigDecimal(120.0))))
                                    .addLineItem(new Goods(4,new Flower(4,"sdfd",new BigDecimal(140.0))))
                                        .pay(PaymentMethodFactory.getPaymentMethod(new Card("John Doe", "4111111111111111", "123", "01/22")));

    }
}

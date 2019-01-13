package main.java.store.servicePaymentStrategy;

import main.java.database.GoodDB;
import main.java.goods.Goods;
import main.java.store.serviceDiscountStrategy.DiscountMethodFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Goods> lineItems = new ArrayList<>();
    private  BigDecimal sum = new BigDecimal(0);
    GoodDB goodDB = new GoodDB();
    private DiscountMethodFactory discountMethodFactory = new DiscountMethodFactory();

    public Bill addLineItem(Goods lineItem){
        lineItems.add(lineItem);
        return this;
    }

    //видалення доного товару з рахнку
    public void removeLineItem(Goods lineItem){
        lineItems.remove(lineItem);
    }

    //підрахунок загальної вартості товарів у чеку
    public BigDecimal getCost(){
        for (Goods g:lineItems) {
          sum = sum.add(g.getPrice());
        }
        return discountMethodFactory.applyDiscount(sum);
    }

    //оплата рахунку
    public Bill pay(PaymentMethod method){
        method.pay(getCost());
        for (Goods g: lineItems)
        goodDB.changeNumbersOfGoods(g.getId());
        return this;
    }

}

package main.java.serviceDecorator;

import main.java.goods.Product;

import java.math.BigDecimal;

public class PutInPot extends ServiceDecorator {

    Product product;

    public PutInPot(Product product) {
        this.product = product;
    }

    @Override
    public ServiceDecorator done() {
        System.out.println("put flower in a pot");
        return this;
    }

    @Override
    public BigDecimal getPrice() {
        product.setPrice(product.getPrice().add(BigDecimal.valueOf(200)));
        return product.getPrice();
    }
}

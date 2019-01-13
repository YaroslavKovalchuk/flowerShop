package main.java.serviceDecorator;

import main.java.goods.Product;

import java.math.BigDecimal;

public class PutInWrapper extends ServiceDecorator {

    Product product;

    public PutInWrapper(Product product) {
        this.product = product;
    }

    @Override
    public ServiceDecorator done() {
        System.out.println("put flower in a Wrapper");
        return this;
    }

    @Override
    public BigDecimal getPrice() {
        product.setPrice(product.getPrice().add(BigDecimal.valueOf(250)));
        return product.getPrice();
    }
}

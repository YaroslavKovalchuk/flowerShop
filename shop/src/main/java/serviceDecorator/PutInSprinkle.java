package main.java.serviceDecorator;

import main.java.goods.Product;

import java.math.BigDecimal;

public class PutInSprinkle extends ServiceDecorator {

    Product product;

    public PutInSprinkle(Product product) {
        this.product = product;
    }
    @Override
    public ServiceDecorator done() {
        System.out.println("put flower in a sprinkle");
        return this;
    }

    @Override
    public BigDecimal getPrice() {
        product.setPrice(product.getPrice().add(BigDecimal.valueOf(250)));
        return product.getPrice();
    }
}

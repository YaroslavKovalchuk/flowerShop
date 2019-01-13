package main.java.serviceDecorator;

import main.java.goods.Product;

import java.math.BigDecimal;

public class MakeBouquet extends ServiceDecorator {

    Product product;

    public MakeBouquet(Product product) {
            this.product = product;
    }

    @Override
    public ServiceDecorator done() {
        System.out.println("created a bouquet");
        return this;
    }

    public BigDecimal getPrice() {
        product.setPrice(product.getPrice().add(BigDecimal.valueOf(100)));
        return product.getPrice();
    }


}

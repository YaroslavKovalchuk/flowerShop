package main.java.goods;

import java.math.BigDecimal;

public abstract class Product {

    private int id;
    private String name;
    private BigDecimal price = new BigDecimal(0);
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getType() {
        return type;
    }

    public void setType(String type){this.type = type;}
}

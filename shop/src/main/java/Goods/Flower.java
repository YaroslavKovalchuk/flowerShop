package Goods;

import java.math.BigDecimal;

public class Flower extends Product{
    private String type;

    public Flower(){}

    public Flower(int id, String name, BigDecimal price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

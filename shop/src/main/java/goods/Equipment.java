package main.java.goods;

import java.math.BigDecimal;

public class Equipment extends Product {

    public Equipment(int id, String name, BigDecimal price){
        setId(id);
        setName(name);
        setPrice(price);
    }
}

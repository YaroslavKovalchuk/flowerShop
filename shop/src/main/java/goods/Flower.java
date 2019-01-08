package goods;

import java.math.BigDecimal;
import java.util.ArrayList;

import goods.Properties.*;

public class Flower extends Product{
    private String type;
    private ArrayList<FlowersProperty> properties = new ArrayList<FlowersProperty>();


    public Flower(int id, String name, BigDecimal price, ArrayList<FlowersProperty> properties){
        this.id = id;
        this.name = name;
        this.price = price;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){this.type = type;}

    public void addProperty(FlowersProperty property){
        properties.add(property);
    }
}

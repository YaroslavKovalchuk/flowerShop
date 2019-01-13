package main.java.goods;

import java.util.ArrayList;
import java.util.List;

public class BunchOfFlowers extends Product{

    private List<Flower> flowers;

    public BunchOfFlowers(){
        flowers = new ArrayList<Flower>();
    }

    public BunchOfFlowers(int id, String name, List<Flower> flowers) {
        setId(id);
        setName(name);
        this.flowers = flowers;
        for (Flower f : flowers){
            setPrice(getPrice().add(f.getPrice()));
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        setPrice(getPrice().add(flower.getPrice()));
    }
}

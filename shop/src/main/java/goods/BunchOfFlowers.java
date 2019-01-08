package goods;

import service.Service;
import java.util.ArrayList;

public class BunchOfFlowers extends Product{
    private ArrayList<Flower> flowers;
    private ArrayList<Service> services;

    public BunchOfFlowers(){
        flowers = new ArrayList<Flower>();
        services = new ArrayList<Service>();
    }

    public BunchOfFlowers(int id, String name, ArrayList<Flower> flowers, ArrayList<Service> services) {
        this.id = id;
        this.name = name;
        this.flowers = flowers;
        this.services = services;
        for (Flower f : flowers){
            price.add(f.getPrice());
        }
        for (Flower f : flowers) price.add(f.getPrice());
        for (Service s : services) price.add(s.getPrice());
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }


    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service service){
        services.add(service);
        price.add(service.getPrice());
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        price.add(flower.getPrice());
    }
}

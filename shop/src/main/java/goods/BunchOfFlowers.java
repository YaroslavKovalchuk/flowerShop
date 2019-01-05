package Goods;

import service.Service;

import java.util.ArrayList;

public class BunchOfFlowers extends Product{
    private ArrayList<Flower> flowers;
    private ArrayList<Service> services;

    public BunchOfFlowers(){
        flowers = new ArrayList<>();
        services = new ArrayList<>();
    }

    public BunchOfFlowers(int id, String name, ArrayList<Flower> flowers, ArrayList<Service> services) {
        this.id = id;
        this.name = name;
        this.flowers = flowers;
        this.services = services;
        for (Flower f : flowers){
            price.add(f.getPrice());
        }
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }


    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service service){
        services.add(service);
    }
}

package Goods;

import java.util.HashMap;

public class Repository {
    private HashMap<String,String> map; //name of service, name of flower;


    public Repository(){
        map = new HashMap<>();
    }

    public Repository(HashMap<String, String> map){
        this.map = map;
    }

    public void assignServiceToFlower(String service, String flower){
        map.put(service,flower);
    }

    public HashMap<String, String> getMap(){
        return map;
    }


}

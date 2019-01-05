package service;

import Goods.BunchOfFlowers;

public class PutInPot extends Service{

    public PutInPot(BunchOfFlowers bunchOfFlowers) {
        bunchOfFlowers.addService(this);
    }
    @Override
    public void done() {
        System.out.println("put flower in a pot - successfully");
    }
}

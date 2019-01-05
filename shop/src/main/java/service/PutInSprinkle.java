package service;

import goods.BunchOfFlowers;

public class PutInSprinkle extends Service {
    public PutInSprinkle(BunchOfFlowers bunchOfFlowers) {
        bunchOfFlowers.addService(this);
    }
    @Override
    public void done() {
        System.out.println("put flower in a sprinkle - successfully");
    }
}

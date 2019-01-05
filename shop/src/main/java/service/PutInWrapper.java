package service;

import goods.BunchOfFlowers;

public class PutInWrapper extends Service{
    public PutInWrapper(BunchOfFlowers bunchOfFlowers) {
        bunchOfFlowers.addService(this);
    }

    @Override
    public void done() {
        System.out.println("put flower in a Wrapper- successfully");
    }
}

package service;

import goods.BunchOfFlowers;

public class MakeBouquet extends Service {

    public MakeBouquet(BunchOfFlowers bunchOfFlowers) {
        bunchOfFlowers.addService(this);
    }

    @Override
    public void done() {
        System.out.println("created a bouquet");
    }


}

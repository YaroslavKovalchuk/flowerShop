package main.java.store;


public class DipartmentStore extends Store{

    private String location;

    public DipartmentStore(String name) {
        super(name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

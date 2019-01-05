import database.CustomerDB;

public class Main {
    public static void main(String[] args) {
        CustomerDB customerDB = new CustomerDB();
        System.out.println(customerDB.getCustomerFromDB("Ivan","1234"));
    }
}

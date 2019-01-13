package main.java.store;

import main.java.database.EmployeeDB;
import main.java.database.GoodDB;
import main.java.goods.Goods;
import main.java.personalData.Employee;
import main.java.store.serviceDiscount.DiscountMethodFactory;
import main.java.store.servicePayment.Bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Store {

    private String name;
    private GoodDB goodDB = new GoodDB();
    private Map<Goods,Integer> goodsList = new HashMap<>();
    private EmployeeDB employeeDB = new EmployeeDB();

    private Bill bill;

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addGoods(Goods goods,int numbers){
        return goodDB.addGoodToDB(goods,numbers);
    }

    public Map<Goods,Integer> getGoodsList(){
        return goodDB.getAllGoodsFormDB();
    }

    public List<Employee> getEmployees() {
        return employeeDB.getAllEmploeesFormDB();
    }

    public boolean addEmployees(Employee employees) {
       return employeeDB.addEmploeeToDB(employees);
    }

    public Employee getEmployee(int id){
        return employeeDB.getEmploeeFromDB(id);
    }

    public Bill createBill() {
        return new Bill();
    }

}

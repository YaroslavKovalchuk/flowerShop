package main.java.store;

import main.java.database.EmployeeDB;
import main.java.database.GoodDB;
import main.java.goods.Goods;
import main.java.goods.Product;
import main.java.personalData.Employee;
import main.java.store.servicePaymentStrategy.Bill;

import java.util.HashMap;
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

    //додавання товару
    public boolean setGoods(Product goods, int numbers){
        return goodDB.addGoodToDB(goods,numbers);
    }

    //отримання товару по ід
    public Goods getGoodsById(int id) {
        return goodDB.getGoods(id);
    }

    //отримання списку усіх товарів
    public Map<Goods,Integer> getGoodsList(){
        return goodDB.getAllGoodsFormDB();
    }

    //Вивід катологу товарів на консоль
    public void showAllGoods(){
        for (Goods g: getGoodsList().keySet()) {
            System.out.println(g.toString());
        }
    }

    //додавання працівника
    public boolean addEmployees(Employee employees) {
       return employeeDB.addEmploeeToDB(employees);
    }

    //отримання працівника по ід
    public Employee getEmployeeById(int id){
        return employeeDB.getEmploeeFromDB(id);
    }

    //Створення рахунку товарів
    public Bill createBill() {
        return new Bill();
    }

}

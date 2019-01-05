package store;

import database.EmployeeDB;
import database.GoodDB;
import personalData.Employee;

import java.util.List;

public class Store {

    private String name;
    private Employee employee = new Employee();
    private GoodDB goodDB;
    protected EmployeeDB employeeDB = new EmployeeDB();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}

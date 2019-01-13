package main.java.database;

import main.java.personalData.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;

    private final String SELECT_ALL = "SELECT * FROM employee";
    private final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private final String INSERT = "INSERT INTO employee VALUES(?,?,?,?)";

    private Employee employee = new Employee();
    private List<Employee> employees = new ArrayList<>();


    //Додавання працівника до бази даних
    public boolean addEmploeeToDB(Employee employee){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setString(3,employee.getPosition());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.execute();
            dbWorker.getConnection().commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    //Отримання працівника з бази даних по ід
    public Employee getEmploeeFromDB(int id) {
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement.setObject(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setName(resultSet.getString(2));
            employee.setPosition(resultSet.getString(3));
            employee.setSalary(resultSet.getDouble(4));
            dbWorker.getConnection().commit();
            dbWorker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // отриманні списку всіх працівників
    public List<Employee> getAllEmploeesFormDB(){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee e = new Employee();
                e.setId(resultSet.getInt(1));
                e.setName(resultSet.getString(2));
                e.setPosition(resultSet.getString(3));
                e.setSalary(resultSet.getDouble(4));
                employees.add(e);
            }
            dbWorker.getConnection().commit();
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

}

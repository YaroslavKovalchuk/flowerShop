package main.java.database;


import main.java.personalData.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;
    private CreditCardDB creditCardDB = new CreditCardDB();

    private final String SELECT_ALL = "SELECT * FROM customer";
    private final String SELECT_ONE = "SELECT * FROM customer WHERE login= ? AND password = ?";
    private final String INSERT = "INSERT INTO customer VALUES(?,?,?,?,?)";

    private Customer customer = new Customer();
    private List<Customer> customers = new ArrayList<>();


    //Додавання клієнта до бази даних
    public boolean addCustomerToDB(Customer customer){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getLogin());
            preparedStatement.setString(4,customer.getPassword());
            preparedStatement.setString(5,customer.getCard().getNumber());
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

    //Отримання клієнта з бази даних по логіну і паролю
    public Customer getCustomerFromDB(String login, String password){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ONE);
            preparedStatement.setObject(1,login);
            preparedStatement.setObject(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer = new Customer();
            customer.setId(resultSet.getInt(1));
            customer.setName(resultSet.getString(2));
            customer.setLogin(resultSet.getString(3));
            customer.setPassword(resultSet.getString(4));
            customer.setCard(creditCardDB.getCreditCardFromDB(resultSet.getString(5)));
            dbWorker.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       return customer;
    }

    // отримання списку всіх кілєнтів
    public List<Customer> getAllCustomerFormDB(){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer c = new Customer();
                c.setId(resultSet.getInt(1));
                c.setName(resultSet.getString(2));
                c.setLogin(resultSet.getString(3));
                c.setPassword(resultSet.getString(4));

                customers.add(c);
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
        return customers;
    }
}

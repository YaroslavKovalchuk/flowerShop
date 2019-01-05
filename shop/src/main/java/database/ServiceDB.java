package database;


import service.Service;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDB {
    private PreparedStatement preparedStatement = null;
    private DBWorker dbWorker;

    private final String SELECT_ALL = "SELECT * FROM service";
    private final String SELECT_ONE = "SELECT * FROM service WHERE id = ?";
    private final String INSERT = "INSERT INTO service VALUES(?,?,?,?)";

    private Service service;
    private List<Service> services = new ArrayList<>();


    //Додавання сервісу до бази даних
    public boolean addServiceToDB(int id, String name, String discribe, BigDecimal price){
        dbWorker  = new DBWorker();
        try {
            dbWorker.getConnection().setAutoCommit(false);
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,discribe);
            preparedStatement.setBigDecimal(4,price);
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

}

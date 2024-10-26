package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {


     // Classe que etsabelece a conexão com o banco de dados

    private static ConnectionManager connectionManager;

    private ConnectionManager(){

    }

    public static ConnectionManager getInstance(){
        if(connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM555028",
                    "020106");
            System.out.println("Connection established!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


   /* public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
    }*/

}

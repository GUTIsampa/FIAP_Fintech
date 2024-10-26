package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static ConnectionManager connectionManager;
    private final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final String usuario = "RM555028";
    private final String senha =  "020106";

    private ConnectionManager(){

    }

    public static ConnectionManager getInstance(){
        if(connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection (this.url, this.usuario, this.senha);
            System.out.println("Conexão aberta");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }



    /*public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
    }*/


}

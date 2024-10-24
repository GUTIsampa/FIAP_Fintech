package Model;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

    public class Conectar {
        public static void main( String[] args )
        {
            try {
                Connection conectar = ConnectionFactory.getConnection();
                System.out.println("Conexão realizada!");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
}

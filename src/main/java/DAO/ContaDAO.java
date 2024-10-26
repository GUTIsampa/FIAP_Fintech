package DAO;


import Model.ContaModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ContaDAO {
    public ContaDAO() throws SQLException {

    }
    public Connection abrirConexao(){
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        return connectionManager.getConnection();

    }

    public void cadastrar(ContaModel conta) throws SQLException {
        Connection conectar = this.abrirConexao();
        String sql = "INSERT INTO t_conta (nr_saldo, id_email, st_conta, senha, nm_usuario, dt_abertura, dt_nasc) VALUES (0, ?, ?, ?, ?,?, ?)";

        //

        try (PreparedStatement stm = conectar.prepareStatement(sql)) {
            stm.setString(1, conta.getId_email());
            stm.setString(2, "Ativo");
            stm.setString(3, conta.getSenha());
            stm.setString(4, conta.getNm_usuario());
            // Para pegar a data atual
            java.sql.Date dt_abertura = new java.sql.Date(conta.getDt_abertura().getTime());

            // Convertendo para java.sql.Date
            stm.setDate(5, dt_abertura);

            // Para a data de nascimento
            Date dt_nasc = new java.sql.Date(conta.getDt_nasc().getTime());
            stm.setDate(6, dt_nasc);

            stm.executeUpdate();

            conectar.close();

        }
    }

}

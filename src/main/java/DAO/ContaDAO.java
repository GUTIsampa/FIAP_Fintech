package DAO;


import Model.ContaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ContaDAO {
    public ContaDAO() throws SQLException {

    }
    public Connection abrirConexao(){
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        return connectionManager.getConnection();

    }

    public void cadastrar(ContaModel conta) throws SQLException {
        Connection conectar = this.abrirConexao();
        String sql = "INSERT INTO t_conta (nr_saldo, id_email, st_conta, senha, nm_usuario) VALUES (0, ?, ?, ?, ?)";

        //

        try (PreparedStatement stm = conectar.prepareStatement(sql)) {
            stm.setString(1, conta.getId_email());
            stm.setString(2, conta.getSt_conta());
            stm.setString(3, conta.getSenha());
            stm.setString(4, conta.getNm_usuario());
/*
            // Para pegar a data atual
            java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis());
            stm.setDate(5, dataAtual);

            // Para a data de nascimento
            stm.setDate(6, conta.getDt_nasc()); // Supondo que getDt_nasc() retorne java.sql.Date*/

            stm.executeUpdate();

            conectar.close();

        }
    }

}

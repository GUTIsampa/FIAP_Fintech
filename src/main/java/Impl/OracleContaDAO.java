package Impl;

import DAO.ConnectionManager;
import DAO.ContaDAO;
import Model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OracleContaDAO implements ContaDAO {
    private Connection con;

    @Override
    public boolean validarUsuario(Conta conta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager
                    .getInstance()
                    .getConnection();

            String sql = "select * from t_conta where id_email = ? and senha = ? ";

            ps = con.prepareStatement(sql);
            ps.setString(1, conta.getEmail());
            ps.setString(2, conta.getSenha());
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
/*
    public static void main(String[] args) {
        OracleContaDAO dao = new OracleContaDAO();
        Conta conta = new Conta();
        dao.validarUsuario(conta);
    }*/

}

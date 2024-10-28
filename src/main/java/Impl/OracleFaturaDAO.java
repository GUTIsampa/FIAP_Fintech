package Impl;

import DAO.ConnectionManager;
import DAO.FaturaDAO;
import Model.Cartao;
import Model.Fatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import Exception.DBException;

public class OracleFaturaDAO implements FaturaDAO {
    private Connection con;

    @Override
    public void cadastrar(Fatura fatura) throws DBException {
        PreparedStatement stmt = null;

        try {
            con = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO t_fatura (id_fatura, id_cartao, val_fatura, dt_vencimento_fatura, nm_fatura ) VALUES (?,?,?,?,?)";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fatura.getId_fatura());
            stmt.setInt(2, fatura.getId_cartao());
            stmt.setDouble(3, fatura.getVl_fatura());
            java.sql.Date dt_vencimento_fatura = new java.sql.Date(fatura.getVencimento_fatura().getTime());
            stmt.setDate(4, dt_vencimento_fatura);
            stmt.setString(5, fatura.getNm_fatura());
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar fatura");
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Fatura fatura) throws DBException {

    }

    @Override
    public void excluir(int codigo) throws DBException {

    }

    @Override
    public Cartao buscar(int id) {
        return null;
    }

    @Override
    public List<Cartao> listar() {
        return List.of();
    }
}

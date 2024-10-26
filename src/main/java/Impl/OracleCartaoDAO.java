package Impl;

import DAO.CartaoDAO;
import DAO.ConnectionManager;
import Exception.DBException;
import Model.Cartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleCartaoDAO implements CartaoDAO {
    private Connection connect;

    @Override
    public void cadastrar(Cartao cartao) throws DBException {
        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO t_cartao (ID_CARTAO, CD_CONTA, NR_CARTAO, NM_BANDEIRA, DT_VENCIMENTO, NR_CVV) VALUES (2, 48, ?, ?, ?, ?)";



            stmt = connect.prepareStatement(sql);
            stmt.setString(1, cartao.getNr_cartao());
            stmt.setString(2, cartao.getBandeira());
            java.sql.Date dt_vencimento = new java.sql.Date(cartao.getVencimento().getTime());
            stmt.setDate(3, dt_vencimento);
            stmt.setString(4, cartao.getCd_seguranca());
            stmt.executeUpdate();
            stmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar cartao");
        } finally {
            try {
                stmt.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Cartao cartao) throws DBException {

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

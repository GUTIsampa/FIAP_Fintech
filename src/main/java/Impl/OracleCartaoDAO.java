package Impl;

import DAO.CartaoDAO;
import DAO.ConnectionManager;
import Exception.DBException;
import Model.Cartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OracleCartaoDAO implements CartaoDAO {
    private Connection connect;

    @Override
    public void cadastrar(Cartao cartao) throws DBException {
        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO t_cartao (ID_CARTAO, CD_CONTA, NR_CARTAO, NM_BANDEIRA, DT_VENCIMENTO, NR_CVV) VALUES (1, 48, ?, ?, ?, ?)";



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

        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE t_cartao SET " +
                    "NR_CARTAO = ?, " +
                    "NM_BANDEIRA = ?, " +
                    "DT_VENCIMENTO = ?," +
                    "NR_CVV = ? " +
                    "where ID_CARTAO = 1";



            stmt = connect.prepareStatement(sql);
            stmt.setString(1, cartao.getNr_cartao());
            stmt.setString(2, cartao.getBandeira());
            java.sql.Date dt_vencimento = new java.sql.Date(cartao.getVencimento().getTime());
            stmt.setDate(3, dt_vencimento);
            stmt.setString(4, cartao.getCd_seguranca());
            stmt.executeUpdate();
            stmt.close();

            System.out.println(cartao.getNr_cartao());
            System.out.println(cartao.getBandeira());
            System.out.println(cartao.getVencimento());
            System.out.println(cartao.getCd_seguranca());


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar as informações do cartao");
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
    public void excluir(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM t_cartao WHERE ID_CARTAO = ?";
            stmt = connect.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro remover o cartao");
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
    public Cartao buscar(int id) {
        Cartao cartao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_cartao WHERE ID_CARTAO = ?";
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                String cvv = rs.getString("NR_CVV");

                cartao = new Cartao(nr_cartao, bandeira, date_vencimento, cvv);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cartao;
    }

    @Override
    public List<Cartao> listar() {
        List<Cartao> lista = new ArrayList<Cartao>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connect = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_cartao";
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                LocalDate data = rs.getDate("DT_VENCIMENTO")
                        .toLocalDate();
                String cvv = rs.getString("NR_CVV");

                Cartao cartao = new Cartao(nr_cartao, bandeira, date_vencimento, cvv);
                lista.add(cartao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}

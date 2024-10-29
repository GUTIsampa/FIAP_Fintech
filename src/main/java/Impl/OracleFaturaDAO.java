package Impl;

import DAO.ConnectionManager;
import Model.Cartao;
import Model.Fatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import Exception.DBException;

public class OracleFaturaDAO {
    private Connection con;

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


    public void atualizar(Fatura fatura) throws DBException {
        PreparedStatement stmt = null;

        try {
            con = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE t_fatura SET " +
                    "VAL_FATURA = ? ," +
                    "DT_VENCIMENTO_FATURA = ? ," +
                    "NM_FATURA = ? " +
                    "where ID_FATURA = ?";


            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, fatura.getVl_fatura());
            java.sql.Date dt_vencimento = new java.sql.Date(fatura.getVencimento_fatura().getTime());
            stmt.setDate(2, dt_vencimento);
            stmt.setString(3, fatura.getNm_fatura());
            stmt.setInt(4, fatura.getId_fatura());
            stmt.executeUpdate();
            stmt.close();

            System.out.println(fatura.getId_cartao());
            System.out.println(fatura.getVl_fatura());
            System.out.println(fatura.getNm_fatura());
            System.out.println(fatura.getVencimento_fatura());


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar as informações do cartao");
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void excluir(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try {
            con = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM t_fatura WHERE ID_FATURA = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover fatura");
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Fatura buscar(int id) {
        Fatura fatura = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_fatura WHERE ID_FATURA = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer id_fatura = rs.getInt("ID_CARTAO");
                Integer id_cartao = rs.getInt("ID_CARTAO");
                Double val_fatura = rs.getDouble("VAL_FATURA");
                Date date_vencimento_fatura = rs.getDate("DT_VENCIMENTO_FATURA");
                String nm_fatura = rs.getString("NM_FATURA");

                fatura = new Fatura(id_fatura, id_cartao, val_fatura, date_vencimento_fatura, nm_fatura);
                System.out.println(id_fatura);
                System.out.println(id_cartao);
                System.out.println(val_fatura);
                System.out.println(date_vencimento_fatura);
                System.out.println(nm_fatura);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fatura;
    }

    public List<Cartao> listar() {
        return List.of();
    }
}

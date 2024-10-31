package Impl;

import DAO.ConnectionManager;
import Model.Meta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Exception.DBException;

public class OracleMetaDAO {
    private Connection conn;

    public void cadastrar(Meta meta) {
        PreparedStatement stmt = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO t_meta (id_meta, cd_conta, valor_meta, data_limite, nome_meta) VALUES (?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, meta.getId_meta());
            stmt.setInt(2, meta.getCd_conta());
            stmt.setDouble(3, meta.getValor_meta());
            Date dt_limite = new Date(meta.getData_limite().getTime());
            stmt.setDate(4, dt_limite);
            stmt.setString(5, meta.getNome_meta());
            stmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar(Meta meta) throws DBException {
       PreparedStatement stmt = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE t_meta SET " +
                    "VALOR_META = ? ," +
                    "DATA_LIMITE = ? ," +
                    "NOME_META = ? " +
                    "where ID_META = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, meta.getValor_meta() );
            java.sql.Date dt_limite = new java.sql.Date(meta.getData_limite().getTime());
            stmt.setDate(2, dt_limite );
            stmt.setString(3, meta.getNome_meta());
            stmt.setInt(4, meta.getId_meta());
            stmt.executeUpdate();
            stmt.close();



        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar as informações do cartao");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluir(Meta meta) throws DBException {
        
    }
}

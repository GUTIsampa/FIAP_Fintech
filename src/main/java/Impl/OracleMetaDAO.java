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
}

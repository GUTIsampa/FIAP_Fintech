package Impl;

import DAO.ConnectionManager;
import Model.Cartao;
import Model.Meta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void excluir(int meta) throws DBException {
        PreparedStatement stmt = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM t_meta WHERE ID_META = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, meta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro remover a meta do cartao");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Meta buscarMeta(int id) throws DBException {
        Meta meta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_meta WHERE ID_META = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer id_meta = rs.getInt("ID_META");
                Integer cd_conta = rs.getInt("CD_CONTA");
                Double vl_meta = rs.getDouble("VALOR_META");
                java.util.Date date_limite = rs.getDate("DATA_LIMITE");
                String nm_meta = rs.getString("NOME_META");

                meta = new Meta(id_meta, cd_conta, vl_meta, date_limite, nm_meta);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meta;
    }

    public List<Meta> listar() {
        List<Meta> lista = new ArrayList<Meta>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_meta";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                Integer id_meta = rs.getInt("ID_META");
                Integer cd_conta = rs.getInt("CD_CONTA");
                Double vl_meta = rs.getDouble("VALOR_META");
                java.util.Date date_limite = rs.getDate("DATA_LIMITE");
                String nm_meta = rs.getString("NOME_META");

                Meta meta = new Meta(id_meta, cd_conta, vl_meta, date_limite, nm_meta);;
                lista.add(meta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}

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

            String sql = "INSERT INTO t_meta (id_meta, cd_conta, valor_meta, nome_meta) VALUES (?,?,?,?)";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, meta.getId_meta());
            stmt.setInt(2, meta.getCd_conta());
            stmt.setDouble(3, meta.getValor_meta());
            stmt.setString(4, meta.getNome_meta());
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

    public void atualizar(String nome, Double valor) throws DBException {
       PreparedStatement stmt = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            Meta meta = new Meta();

            String sql = "UPDATE t_meta SET " +
                    "VALOR_META = ? " +
                    "where NOME_META = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, nome);
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
    public List<Meta> buscarMeta(int cd_conta) throws DBException {
        List<Meta> meta = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT valor_meta, nome_meta  FROM t_meta WHERE cd_conta = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cd_conta);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Meta m = new Meta();
                Double vl_meta = rs.getDouble("VALOR_META");
                String nm_meta = rs.getString("NOME_META");
                m.setValor_meta(vl_meta);
                m.setNome_meta(nm_meta);

                meta.add(m);

                System.out.println(vl_meta + "valor retornado");
                System.out.println(nm_meta + "valor retornado");

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
                String nm_meta = rs.getString("NOME_META");

                Meta meta = new Meta(id_meta, cd_conta, vl_meta, nm_meta);;
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

    public static void main(String[] args) throws DBException {
        OracleMetaDAO dao = new OracleMetaDAO();
        dao.buscarMeta(61);
    }
}

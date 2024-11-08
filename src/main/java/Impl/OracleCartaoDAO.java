package Impl;

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

public class OracleCartaoDAO {
    private Connection connect;

    public int contarCartoes(int idConta) throws SQLException, DBException {
        Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int quantidade = 0;

        try {
            conectar = ConnectionManager.getInstance().getConnection();

            String sql = "select count(*) from t_cartao where cd_conta = ?";
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, idConta);

            rs = pst.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt(1);
            }
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conectar != null) conectar.close();
        }

        return quantidade;
    }


    public void cadastrar(Cartao cartao) throws DBException, SQLException {
        PreparedStatement stmt = null;

        int idConta = cartao.getConta();

        // Verificar quantos cartões já estão cadastrados para essa conta
        int qtdCartao = contarCartoes(idConta);
        if (qtdCartao < 5) {


            try {
                connect = ConnectionManager.getInstance().getConnection();

                String sql = "INSERT INTO t_cartao (CD_CONTA, NR_CARTAO, NM_BANDEIRA, DT_VENCIMENTO, NR_CVV, NOMETITULAR) VALUES ( ?, ?, ?, ?, ?, ?)";


                stmt = connect.prepareStatement(sql);
                stmt.setInt(1, idConta);
                stmt.setString(2, cartao.getNr_cartao());
                stmt.setString(3, cartao.getBandeira());
                java.sql.Date dt_vencimento = new java.sql.Date(cartao.getVencimento().getTime());
                stmt.setDate(4, dt_vencimento);
                stmt.setString(5, cartao.getCd_seguranca());
                stmt.setString(6, cartao.getNomeTitular());
                stmt.executeUpdate();
                String commit = "commit";
                stmt.executeQuery(commit);
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
        } else {
            throw new DBException("A conta já possui limite máximo de 5 Cartões permitidos");
        }
    }

    public void atualizar(Cartao cartao) throws DBException {

        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE t_cartao SET " +
                    "NR_CARTAO = ?, " +
                    "NM_BANDEIRA = ?, " +
                    "DT_VENCIMENTO = ?," +
                    "NR_CVV = ? ," +
                    "NOMETITULAR = ? " +
                    "where ID_CARTAO = ?";


            stmt = connect.prepareStatement(sql);
            stmt.setString(1, cartao.getNr_cartao());
            stmt.setString(2, cartao.getBandeira());
            java.sql.Date dt_vencimento = new java.sql.Date(cartao.getVencimento().getTime());
            stmt.setDate(3, dt_vencimento);
            stmt.setString(4, cartao.getCd_seguranca());
            stmt.setString(5, cartao.getNomeTitular());
            stmt.setInt(6, cartao.getCartao());
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

    public void excluir(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM t_cartao WHERE ID_CARTAO = ?";
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, codigo);
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

    public List<Cartao> buscar(int id) {
        List<Cartao> listaCartao = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connect = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_cartao WHERE CD_CONTA = ?";
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer id_conta = rs.getInt("CD_CONTA");
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                String cvv = rs.getString("NR_CVV");
                Integer id_cartao = rs.getInt("ID_CARTAO");
                String nomeTitular = rs.getString("NOMETITULAR");

               Cartao cartao = new Cartao(id_conta,nr_cartao, bandeira, date_vencimento, cvv, id_cartao, nomeTitular);

               listaCartao.add(cartao);
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
        return listaCartao;
    }

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
                Integer cd_conta = rs.getInt("CD_CONTA");
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                LocalDate data = rs.getDate("DT_VENCIMENTO")
                        .toLocalDate();
                String cvv = rs.getString("NR_CVV");
                Integer id = rs.getInt("ID_CARTAO");
                String nomeTitular = rs.getString("NOMETITULAR");

                Cartao cartao = new Cartao(cd_conta, nr_cartao, bandeira, date_vencimento, cvv, id, nomeTitular);
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

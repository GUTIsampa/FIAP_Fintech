package Impl;

<<<<<<< HEAD
import DAO.CartaoDAO;
=======
>>>>>>> parent of 01f3cba (revert)
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

<<<<<<< HEAD
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
=======
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

                String sql = "INSERT INTO t_cartao (ID_CARTAO, CD_CONTA, NR_CARTAO, NM_BANDEIRA, DT_VENCIMENTO, NR_CVV) VALUES ( ?, ?, ?, ?, ?, ?)";


                stmt = connect.prepareStatement(sql);
                stmt.setInt(1, cartao.getCartao());
                stmt.setInt(2, idConta);
                stmt.setString(3, cartao.getNr_cartao());
                stmt.setString(4, cartao.getBandeira());
                java.sql.Date dt_vencimento = new java.sql.Date(cartao.getVencimento().getTime());
                stmt.setDate(5, dt_vencimento);
                stmt.setString(6, cartao.getCd_seguranca());
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

>>>>>>> parent of 01f3cba (revert)
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


<<<<<<< HEAD

=======
>>>>>>> parent of 01f3cba (revert)
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

<<<<<<< HEAD
    @Override
=======
>>>>>>> parent of 01f3cba (revert)
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

<<<<<<< HEAD
    @Override
=======
>>>>>>> parent of 01f3cba (revert)
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
<<<<<<< HEAD
=======
                Integer id_conta = rs.getInt("ID_CARTAO");
>>>>>>> parent of 01f3cba (revert)
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                String cvv = rs.getString("NR_CVV");

<<<<<<< HEAD
                cartao = new Cartao(nr_cartao, bandeira, date_vencimento, cvv);
=======
                cartao = new Cartao(id_conta,nr_cartao, bandeira, date_vencimento, cvv);
>>>>>>> parent of 01f3cba (revert)

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

<<<<<<< HEAD
    @Override
=======
>>>>>>> parent of 01f3cba (revert)
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
<<<<<<< HEAD
=======
                Integer cd_conta = rs.getInt("CD_CONTA");
>>>>>>> parent of 01f3cba (revert)
                String nr_cartao = rs.getString("NR_CARTAO");
                String bandeira = rs.getString("NM_BANDEIRA");
                Date date_vencimento = rs.getDate("DT_VENCIMENTO");
                LocalDate data = rs.getDate("DT_VENCIMENTO")
                        .toLocalDate();
                String cvv = rs.getString("NR_CVV");
<<<<<<< HEAD

                Cartao cartao = new Cartao(nr_cartao, bandeira, date_vencimento, cvv);
=======
                Integer id = rs.getInt("ID_CARTAO");

                Cartao cartao = new Cartao(cd_conta, nr_cartao, bandeira, date_vencimento, cvv, id);
>>>>>>> parent of 01f3cba (revert)
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
<<<<<<< HEAD

=======
>>>>>>> parent of 01f3cba (revert)
}

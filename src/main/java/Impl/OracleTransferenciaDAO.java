package Impl;

import DAO.ConnectionManager;
import Model.Cartao;
import Model.Transferencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OracleTransferenciaDAO {
    private Connection con;

    public void cadastrarTrans(Transferencias trans){
        PreparedStatement pst = null;
        try {
            con = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO t_transferencias (TP_TRANSFERENCIA, DT_TRANSFERENCIA, VAL_TRANSFERENCIA, NOME_TRANSFERENCIA, ID_CARTAO, CD_CONTA) VALUES ( ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, trans.getTipo_transferencia());
            java.sql.Date dt_trans = new java.sql.Date(trans.getData_transferencia().getTime());
            pst.setDate(2, dt_trans);
            pst.setDouble(3, trans.getValor_transferencia());
            pst.setString(4, trans.getNome_transferencia());
            if (trans.getId_cartao() != 0) {
                pst.setInt(5, trans.getId_cartao());
            } else
                {pst.setNull(5, java.sql.Types.INTEGER);
            }
            pst.setInt(6, trans.getCd_conta());
            pst.executeUpdate();
            String commit = "commit";
            pst.executeQuery(commit);
            pst.close();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Transferencias> buscar(int id) {
        List<Transferencias> listaTransferencias = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM t_transferencias WHERE CD_CONTA = ? order by dt_transferencia desc FETCH FIRST 50 ROWS ONLY";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_transferencia = rs.getInt("ID_TRANSFERENCIA");
                int idCartao = rs.getInt("ID_CARTAO");
                String tpTransferencia = rs.getString("TP_TRANSFERENCIA");
                Date date_trans = rs.getDate("DT_TRANSFERENCIA");
                Double val_transferencia = rs.getDouble("VAL_TRANSFERENCIA");
                String nome_transferencia = rs.getString("NOME_TRANSFERENCIA");
                int cd_conta = rs.getInt("CD_CONTA");


                Transferencias trans = new Transferencias(id_transferencia, tpTransferencia, date_trans, val_transferencia, nome_transferencia, idCartao, cd_conta);
                listaTransferencias.add(trans);
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
        return listaTransferencias;
    }

    public double faturaMesAnterior(int cd_conta, int id_cartao) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double valorSomado = 0.0;

        try {
            con = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(VAL_TRANSFERENCIA) FROM t_transferencias WHERE dt_transferencia >= TRUNC(ADD_MONTHS(SYSDATE, -1), 'MM') AND dt_transferencia < TRUNC(SYSDATE, 'MM') AND CD_CONTA = ? AND TP_TRANSFERENCIA = 'pagamento' AND ID_CARTAO = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cd_conta);
            stmt.setInt(2, id_cartao);
            rs = stmt.executeQuery();
            if (rs.next()) {
                valorSomado = rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valorSomado;
    }

}

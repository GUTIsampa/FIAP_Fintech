package DAO;

import Factory.ConnectionFactory;
import Model.Investimento;
import Model.Transferencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransferenciasDAO {

    private Connection conectar;
    public TransferenciasDAO() throws SQLException {
        conectar = ConnectionFactory.getConnection();
    }
    public void cadastrar(Transferencias transferencias) throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO t_transferencias (id_transferencia, cd_conta, tp_transferencia, dt_transferencia, val_transferencia) VALUES ( ?, ?, ?, ?, ?)");
        stm.setInt(1, transferencias.getId());
        stm.setInt(2, transferencias.getConta());
        stm.setString(3, transferencias.getTipo());
        stm.setDate(4, transferencias.getData());
        stm.setDouble(5, transferencias.getValor());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conectar.close();
    }

    public List<Transferencias> getAll() throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("SELECT * FROM t_transferencias");
        ResultSet resultado = stm.executeQuery();
        List<Transferencias> lista = new ArrayList<>();
        while (resultado.next()){
            Integer transferencia_ = resultado.getInt("id_transferencia");
            Integer codigo_conta = resultado.getInt("cd_conta");
            String tipo_transferencia = resultado.getString("tp_transferencia");
            Date data_transferencia = resultado.getDate("dt_transferencia");
            Double valor_transferencia = resultado.getDouble("val_transferencia");

            Transferencias nv_transferencia = new Transferencias(transferencia_, codigo_conta, tipo_transferencia, valor_transferencia, data_transferencia );
            lista.add(nv_transferencia);
        }

        return lista;
    }

}

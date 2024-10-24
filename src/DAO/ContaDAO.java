package DAO;

import Factory.ConnectionFactory;
import Model.Cartao;
import Model.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

   private Connection conectar;
    public ContaDAO () throws SQLException {
        conectar = ConnectionFactory.getConnection();
    }
    public void cadastrar(Conta conta) throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO t_conta (nr_saldo, id_email, dt_abertura, st_conta, tp_conta) VALUES ( ?, ?, ?, ?, ?)");
        stm.setDouble(1, conta.getSaldo());
        stm.setString(2, conta.getEmail());
        stm.setDate(3, conta.getData());
        stm.setString(4, conta.getStatus());
        stm.setString(5, conta.getTipo());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conectar.close();
    }

    public List<Conta> getAll() throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("SELECT * FROM t_conta");
        ResultSet resultado = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();
        while (resultado.next()){
            Integer cd_conta = resultado.getInt("cd_conta");
            Double saldoConta = resultado.getDouble("nr_saldo");
            String infoEmail = resultado.getString("id_email");
            Date abertura = resultado.getDate("dt_abertura");
            String situacao = resultado.getString("st_conta");
            String tipo = resultado.getString("tp_conta");

            Conta nv_conta = new Conta( saldoConta, infoEmail, abertura, situacao, tipo);
            nv_conta.setConta(cd_conta);
            lista.add(nv_conta);
        }

        return lista;
    }

}

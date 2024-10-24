package DAO;

import Factory.ConnectionFactory;
import Model.Conta;
import Model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InvestimentoDAO {
    private Connection conectar;
    public InvestimentoDAO() throws SQLException {
        conectar = ConnectionFactory.getConnection();
    }
    public void cadastrar(Investimento investimento) throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO t_investimento (id_investimento, cd_conta, tp_investimento, dt_investimento, val_investido, val_rendimento) VALUES ( ?, ?, ?, ?, ?, ?)");
        stm.setInt(1, investimento.getInvestimento());
        stm.setInt(2, investimento.getConta());
        stm.setString(3, investimento.getTp_investimento());
        stm.setDate(4, investimento.getData_investimento());
        stm.setDouble(5, investimento.getVl_investido());
        stm.setDouble(6, investimento.getVl_rendimento());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conectar.close();
    }

    public List<Investimento> getAll() throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("SELECT * FROM t_investimento");
        ResultSet resultado = stm.executeQuery();
        List<Investimento> lista = new ArrayList<>();
        while (resultado.next()){
            Integer investimento = resultado.getInt("id_investimento");
            Integer codeConta = resultado.getInt("cd_conta");
            String investimento_ = resultado.getString("tp_investimento");
            Date data_investimento = resultado.getDate("dt_investimento");
            Double valor_investido = resultado.getDouble("val_investido");
            Double valor_rendimento = resultado.getDouble("val_rendimento");

            Investimento nv_investimento = new Investimento(investimento, codeConta, investimento_, data_investimento, valor_investido, valor_rendimento);
            lista.add(nv_investimento);
        }

        return lista;
    }
}

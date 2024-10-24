package DAO;

import Factory.ConnectionFactory;
import Model.Cartao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CartaoDAO {

    private Connection conectar;
    public CartaoDAO() throws SQLException {
        conectar = ConnectionFactory.getConnection();
    }
    public void cadastrar(Cartao cartao) throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO t_cartao (id_cartao, cd_conta, nr_cartao, nm_bandeira, dt_vencimento, nr_cvv) VALUES ( ?, ?, ?, ?, ?, ?)");
        stm.setInt(1, cartao.getCartao());
        stm.setInt(2, cartao.getConta());
        stm.setString(3, cartao.getNr_cartao());
        stm.setString(4, cartao.getBandeira());
        stm.setDate(5, cartao.getVencimento());
        stm.setDouble(6, cartao.getCd_seguranca());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conectar.close();
    }

    public List<Cartao> getAll() throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("SELECT * FROM t_cartao");
        ResultSet resultado = stm.executeQuery();
        List<Cartao> lista = new ArrayList<>();
        while (resultado.next()){
            Integer id = resultado.getInt("id_cartao");
            Integer cd_conta = resultado.getInt("cd_conta");
            String numero = resultado.getString("nr_cartao");
            String bandeira = resultado.getString("nm_bandeira");
            Date data_vencimento = resultado.getDate("dt_vencimento");
            Integer cvv = resultado.getInt("nr_cvv");

            Cartao nv_cartao = new Cartao(id, cd_conta, numero, bandeira, data_vencimento, cvv);
            lista.add(nv_cartao);
        }

        return lista;
    }

}
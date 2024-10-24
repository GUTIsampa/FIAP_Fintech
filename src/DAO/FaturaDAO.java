package DAO;

import Factory.ConnectionFactory;
import Model.Conta;
import Model.Fatura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {

    private Connection conectar;
    public FaturaDAO () throws SQLException {
        conectar = ConnectionFactory.getConnection();
    }
    public void cadastrar(Fatura fatura) throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("INSERT INTO t_fatura (id_fatura, id_cartao, val_fatura, dt_vencimento_fatura, dt_pagamento_fatura) VALUES ( ?, ?, ?, ?, ?)");
        stm.setInt(1, fatura.getId_fatura());
        stm.setInt(2, fatura.getId_cartao());
        stm.setDouble(3, fatura.getVl_fatura());
        stm.setDate(4, fatura.getVencimento_fatura());
        stm.setDate(5, fatura.getData_pagamento());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conectar.close();
    }

    public List<Fatura> getAll() throws SQLException {
        PreparedStatement stm = conectar.prepareStatement("SELECT * FROM t_fatura");
        ResultSet resultado = stm.executeQuery();
        List<Fatura> lista = new ArrayList<>();
        while (resultado.next()){
            Integer id_fatura = resultado.getInt("id_fatura");
            Integer id_cartao = resultado.getInt("id_cartao");
            Double valor_fatura = resultado.getDouble("val_fatura");
            Date vencimento_fatura = resultado.getDate("dt_vencimento_fatura");
            Date pagamento = resultado.getDate("dt_pagamento_fatura");

            Fatura nv_fatura = new Fatura(id_fatura, id_cartao, valor_fatura, vencimento_fatura, pagamento);
            lista.add(nv_fatura);
        }

        return lista;
    }
}
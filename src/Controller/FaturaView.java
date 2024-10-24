package View;

import DAO.ContaDAO;
import DAO.FaturaDAO;
import Model.Conta;
import Model.Fatura;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class FaturaView {
    public static void main(String[] args) throws SQLException {

      /*  try {

            String dataString = "16/02/2024";
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataUtil;
            java.sql.Date dataSql = null;

            try {
                // Parse da data no formato especificado
                dataUtil = formato.parse(dataString);
                dataSql = new java.sql.Date(dataUtil.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }


            FaturaDAO fatura = new FaturaDAO();
            Fatura novaFatura = new Fatura(5, 5, 1000.00, dataSql, dataSql);
            fatura.cadastrar(novaFatura);
            System.out.println("Fatura cadastrada");
            fatura.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } */


        try {
            FaturaDAO fatura = new FaturaDAO();
            List<Fatura> infoFatura = fatura.getAll();
            for (Fatura novaFatura : infoFatura) {
                System.out.println(novaFatura.getId_fatura() + " " + novaFatura.getId_cartao() + ", " + novaFatura.getVl_fatura() + ", " + novaFatura.getVencimento_fatura() + ", " + novaFatura.getData_pagamento());
            }
            fatura.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
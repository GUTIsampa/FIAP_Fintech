package View;

import DAO.CartaoDAO;
import DAO.ContaDAO;
import Model.Cartao;
import Model.Conta;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class ContaView {
    public static void main(String[] args) throws SQLException {

       /* try {

            String dataString = "25/12/2024";
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


            ContaDAO conta = new ContaDAO();
            Conta novaConta = new Conta(0.00, "leandro@leandro.com", dataSql, "Inativo", "Física");
            conta.cadastrar(novaConta);
            System.out.println("Conta cadastrada");
            conta.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } */


        try {
            ContaDAO conta = new ContaDAO();
            List<Conta> infoConta = conta.getAll();
            for (Conta novaConta : infoConta) {
                System.out.println(novaConta.getSaldo() + " " + novaConta.getEmail() + ", " + novaConta.getData() + ", " + novaConta.getStatus() + ", " + novaConta.getTipo());
            }
            conta.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

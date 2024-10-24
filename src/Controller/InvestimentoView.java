package View;

import DAO.ContaDAO;
import DAO.InvestimentoDAO;
import Model.Conta;
import Model.Investimento;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class InvestimentoView {
    public static void main(String[] args) throws SQLException {

       /* try {

            String dataString = "01/12/2024";
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


            InvestimentoDAO investimento = new InvestimentoDAO();
            Investimento novoInvestimento = new Investimento(3, 23, "CDB", dataSql, 200.00, null  );
            novoInvestimento.setVl_rendimento(novoInvestimento.Rendimento(novoInvestimento.getVl_investido(), 0.01, 3 ));
            investimento.cadastrar(novoInvestimento);
            System.out.println("Investimento cadastrado");
            investimento.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } */

        try {
            InvestimentoDAO investimento = new InvestimentoDAO();
            List<Investimento> infoInvestimento = investimento.getAll();
            for (Investimento novoInvestimento : infoInvestimento) {
                System.out.println(novoInvestimento.getInvestimento() + " " + novoInvestimento.getConta() + ", " + novoInvestimento.getTp_investimento() + ", " + novoInvestimento.getData_investimento() + ", " + novoInvestimento.getVl_investido() + ", " + novoInvestimento.getVl_rendimento());
            }
            investimento.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}


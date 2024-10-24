package View;

import DAO.CartaoDAO;
import Model.Cartao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CartaoView {
    public static void main(String[] args) throws SQLException {

     /*  try {

            String dataString = "20/06/2024";
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


            CartaoDAO conta = new CartaoDAO();
            Cartao novoCartao = new Cartao(5, 23, "555.555.55-55", "Visa", dataSql, 908);
            conta.cadastrar(novoCartao);
            System.out.println("Cartão cadastrado");
            conta.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } */

        try {
            CartaoDAO cartao = new CartaoDAO();
            List<Cartao> infoCartao = cartao.getAll();
            for (Cartao novoCartao : infoCartao) {
                System.out.println(novoCartao.getCartao() + " " + novoCartao.getConta() + ", " + novoCartao.getNr_cartao() + ", " + novoCartao.getBandeira() + ", " + novoCartao.getVencimento() + ", " + novoCartao.getCd_seguranca() );
            }
            cartao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

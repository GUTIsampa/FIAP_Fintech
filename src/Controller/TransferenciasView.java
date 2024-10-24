package View;

import DAO.InvestimentoDAO;
import DAO.TransferenciasDAO;
import Model.Investimento;
import Model.Transferencias;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class TransferenciasView {
    public static void main(String[] args) throws SQLException {

    /*    try {

            String dataString = "12/01/2024";
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


            TransferenciasDAO transferencia = new TransferenciasDAO();
            Transferencias novaTransferencia = new Transferencias(5, 23, "Pagamento", 7000.00, dataSql);
            transferencia.cadastrar(novaTransferencia);
            System.out.println("Transferência cadastrada");
            transferencia.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } */

        try {
            TransferenciasDAO transferencia = new TransferenciasDAO();
            List<Transferencias> infoTransferencia = transferencia.getAll();
            for (Transferencias novaTransferencia : infoTransferencia) {
                System.out.println(novaTransferencia.getId() + " " + novaTransferencia.getConta() + ", " + novaTransferencia.getTipo() + ", " + novaTransferencia.getValor() + ", " + novaTransferencia.getData());
            }
            transferencia.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}

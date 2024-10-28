import Impl.OracleContaDAO;
import Model.Conta;

public class Teste {
    public static void main(String[] args) {
        Conta conta = new Conta("wes@gmail.com", "1245");
        OracleContaDAO dao = new OracleContaDAO();

        if (dao.validarUsuario(conta)) {
            System.out.println("Usuario encontrado");
        } else {
            System.out.println("Usuario nao encontrado");
        }



    }
}

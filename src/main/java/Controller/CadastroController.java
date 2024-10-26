package Controller;

import Model.ContaBuilder;
import Model.ContaModel;

import java.util.Date;

public class CadastroController {
    public static void main(String[] args) {
        ContaModel conta = new ContaBuilder()
                .IdEmail("user@example.com")
                .StConta("ativo")
                .Senha("senha123")
                .NmUsuario("Nome Usuario")
                .build();
        //System.out.printf(conta.getTp_conta()+conta.getId_email()+conta.getSenha());
        // Agora você pode usar o objeto conta como quiser

        try{
            conta.cadastrarConta();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}

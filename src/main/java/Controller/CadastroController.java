package Controller;

import Model.ContaBuilder;
import Model.ContaModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroController{


    public static void main(String[] args) throws ParseException {
        ContaModel conta = new ContaBuilder()
                .IdEmail("testando@oemail.com")
                .Senha("outrasenhaaaaaaaa")
                .NmUsuario("Onovonomeeeeee")
                .DtNasc(new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2004"))
                .build();
        // Agora você pode usar o objeto conta como quiser

        try{
            conta.cadastrarConta();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

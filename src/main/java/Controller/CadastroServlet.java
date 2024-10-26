package Controller;

import Model.ContaBuilder;
import Model.ContaModel;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/cadastros")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String dataNascimento = req.getParameter("dataNascimento");
        ContaModel conta = null;
        try {
            conta = new ContaBuilder()
                    .IdEmail(email)
                    .Senha(senha)
                    .NmUsuario(nome)
                    .DtNasc(new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento))
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Agora você pode usar o objeto conta como quiser

        try{
            conta.cadastrarConta();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/cadastros")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");

        switch(acao) {
            case "cadastrar":

                String nome = req.getParameter("nome");
                String email = req.getParameter("email");
                String senha = req.getParameter("senha");
                String dataNascimento = req.getParameter("dataNascimento");
                ContaModel contaModel;
                try {
                    contaModel = new ContaBuilder()
                            .IdEmail(email)
                            .Senha(senha)
                            .NmUsuario(nome)
                            .DtNasc(new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento))
                            .build();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                // Agora você pode usar o objeto conta como quiser

                try {
                    contaModel.cadastrarConta();
                } catch (Exception e) {
                    e.getMessage();
                }
            case "buscaPorId":
                String idBusca = req.getParameter("id");
                contaModel = new ContaModel();
                try {
                    ContaModel contaAchada = contaModel.buscaPorId(Integer.parseInt(idBusca));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "excluirPorId":
                String idExcluir = req.getParameter("id");
                contaModel = new ContaModel();
                try {
                    contaModel.excluirPorId(Integer.parseInt(idExcluir));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "alterar":
                contaModel = new ContaModel();
                try {
                    ContaModel contaParaAlterar = contaModel.buscaPorId(50);
                    System.out.println(contaParaAlterar.getNm_usuario());
                    System.out.println("chegou");
                    contaParaAlterar.setSenha("EssaSenha");
                    contaParaAlterar.alterar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch(acao) {
            case "listar":
                ContaModel contaModel = new ContaModel();
                try {
                    for (ContaModel conta : contaModel.getAll()) {
                        System.out.println(conta.getId_email());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "alterar":
                contaModel = new ContaModel();
                try {
                    ContaModel contaParaAlterar = contaModel.buscaPorId(50);
                    contaParaAlterar.setSenha("EssaSenha");
                    contaParaAlterar.alterar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}

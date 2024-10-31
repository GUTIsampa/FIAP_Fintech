package Controller;

import Model.Conta;
import Model.ContaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/cadastro")
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
                System.out.println(nome);
                System.out.println(email);
                System.out.println(senha);
                System.out.println(dataNascimento);

                Conta contaModel;
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
                    contaModel.cadastrarConta(contaModel);
                } catch (Exception e) {
                    e.getMessage();
                }

                break;

            case "buscaPorId":
                String idBusca = req.getParameter("id");
                contaModel = new Conta();
                try {
                    Conta contaAchada = contaModel.buscaPorId(Integer.parseInt(idBusca));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;

            case "excluirPorId":
                String idExcluir = req.getParameter("id");
                contaModel = new Conta();
                try {
                    contaModel.excluirPorId(Integer.parseInt(idExcluir));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;

            case "alterar":
                contaModel = new Conta();
                try {
                    Conta contaParaAlterar = contaModel.buscaPorId(50);
                    System.out.println(contaParaAlterar.getNomeUsuario());
                    System.out.println("chegou");
                    contaParaAlterar.setSenha("EssaSenha");
                    contaParaAlterar.alterar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch(acao) {
            case "listar":
                Conta contaModel = new Conta();
                try {
                    for (Conta conta : contaModel.getAll()) {
                        System.out.println(conta.getEmail());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;

            case "alterar":
                contaModel = new Conta();
                try {
                    Conta contaParaAlterar = contaModel.buscaPorId(50);
                    contaParaAlterar.setSenha("EssaSenha");
                    contaParaAlterar.alterar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;

            case "voltar":
                resp.sendRedirect("index.jsp");
        }
    }
}

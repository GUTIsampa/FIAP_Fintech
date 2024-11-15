package Controller;

import DAO.ContaDAO;
import Utils.CriptografiaUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Factory.DaoFactory;
import Model.Conta;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private ContaDAO dao;

    public loginServlet() {
        dao = DaoFactory.getContaDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Obtendo os parâmetros dos formulários
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        Conta conta = new Conta(email, senha);
        String resultadoValidacao = dao.validarUsuario(conta);

        // se houver um usuário no banco de dados, redireciona para a página seguinte, senao, volta a tela de login
        if ("Autenticação bem sucedida".equals(resultadoValidacao)) {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            session.setAttribute("usuario", conta.getNomeUsuario());

            try {
                    conta = conta.buscarPorEmail(email);
                    session.setAttribute("usuario", conta.getNomeUsuario());
                    session.setAttribute("dataCriacao",conta.buscarPorEmail(email).buscarPorDtAbertura(email).getDt_abertura());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            session.setAttribute("id", conta.getCd_conta());
            res.sendRedirect(req.getContextPath() + "/cartao");
        } else if ("Conta inexistente".equals(resultadoValidacao)) {
            req.setAttribute("erro", resultadoValidacao);
            req.setAttribute("cadastrar", "Ainda não possui uma conta? Cadastre-se agora mesmo!");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else if ("Senha incorreta".equals(resultadoValidacao)) {
            req.setAttribute("erro", resultadoValidacao);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}

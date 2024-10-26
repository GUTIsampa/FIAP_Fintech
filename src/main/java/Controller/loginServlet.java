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

        // se houver um usuário no banco de dados, redireciona para a página seguinte, senao, volta a tela de login
        if (dao.validarUsuario(conta)) {
            HttpSession session = req.getSession();
            session.setAttribute("usuario", email);
            req.getRequestDispatcher("Success.jsp").forward(req, res);
        } else {
            req.setAttribute("Erro", "E-mail/senha incorretos");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}

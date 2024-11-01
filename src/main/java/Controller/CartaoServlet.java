package Controller;


import Model.Cartao;
import Model.CartaoBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Exception.DBException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/cartao")
public class CartaoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        Cartao cartao;

        switch (acao) {
            case "cadastrarCartao":
                String nomeCartao = req.getParameter("nomeCartao");
                String numeroCartao = req.getParameter("numeroCartao");
                String codigoCartao = req.getParameter("codCartao");
                String dataVencimento = req.getParameter("dataVencimento");
                String bandeiraCartao = req.getParameter("bandeiraCartao");

                System.out.println(nomeCartao);
                System.out.println(numeroCartao);
                System.out.println(codigoCartao);
                System.out.println(dataVencimento);
                System.out.println(bandeiraCartao);

                try {
                         cartao = new CartaoBuilder()
                                 .setCartao(15)
                                 .setConta(43)
                            .setNome_cartao(nomeCartao)
                            .setNr_cartao(numeroCartao)
                            .setCd_seguranca(codigoCartao)
                            .setVencimento(new SimpleDateFormat("yyyy-MM-dd").parse(dataVencimento))
                            .setBandeira(bandeiraCartao)
                            .build();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                try {
                    cartao.adicionarCartao();
                    req.setAttribute("cartao", "Cartao cadastrado com sucesso");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("cartao.jsp");
                    dispatcher.forward(req, resp);


                } catch (SQLException | DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    RequestDispatcher dispatcher = req.getRequestDispatcher("cartao.jsp");
                    dispatcher.forward(req, resp);
                    return;
                }

                break;



        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        Cartao cartao = new Cartao();
        switch (acao) {
            case "listarCartao":
                int userId = cartao.getConta();
                List<Cartao> cartoes;
                try {
                    cartoes = cartao.buscarCartao(userId);
                    System.out.println("o id é" + userId);
                } catch (DBException e) {
                   e.printStackTrace();
                   req.setAttribute("erro", e.getMessage());
                   RequestDispatcher dispatcher = req.getRequestDispatcher("cartao.jsp");
                   return;
                }
                req.setAttribute("cartoes", cartoes);
                RequestDispatcher dispatcher = req.getRequestDispatcher("cartao.jsp");
                dispatcher.forward(req, resp);
                break;
        }

    }
}
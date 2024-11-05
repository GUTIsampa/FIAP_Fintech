package Controller;


import Impl.OracleCartaoDAO;
import Model.Cartao;
import Model.CartaoBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Exception.DBException;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/cartao")
public class CartaoServlet extends HttpServlet {
    private OracleCartaoDAO oracleCartaoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        oracleCartaoDAO = new OracleCartaoDAO();
    }


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
                                 .setCartao(17)
                                 .setConta(44)
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
        HttpSession session = req.getSession(false);
        Integer cd_conta = (Integer) session.getAttribute("id");
        List<Cartao> cartoes;


        switch (acao) {
            case "listarCartao":

             try{
                 cartoes = this.oracleCartaoDAO.buscar(cd_conta);
                 System.out.println("está sendo chamado");
                 req.setAttribute("cartoes", cartoes);
                 RequestDispatcher dispatcher = req.getRequestDispatcher("cartao.jsp");
                 dispatcher.forward(req, resp);
             } catch (Exception e) {
                 e.printStackTrace();
             }
             break;
        }
    }
}

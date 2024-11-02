package Controller;

import Model.Conta;
import Model.TransferenciaBuilder;
import Model.Transferencias;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Exception.DBException;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/transferencias")
public class TransferenciaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");
        System.out.println(cd_conta_sessao + "chegou aqui");
        String mostrarTrans = req.getParameter("mostrarTrans");

        switch (acao) {
            case "saldo":
                Conta conta = new Conta();
                try {
                    double saldoAtual = conta.buscarPorSaldo(cd_conta_sessao);
                    req.setAttribute("saldoAtual", saldoAtual);
                    RequestDispatcher rd = req.getRequestDispatcher("transferencias.jsp");
                    rd.forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transferencias transferencias;
        String acao = req.getParameter("acao");
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");

        switch (acao) {
            case "cadastrarTrans":
                String nome_trans = req.getParameter("nomeTrans");
                String valor = req.getParameter("valTrans");
                double valorDouble = 0.0;
                if (valor != null && !valor.trim().isEmpty()) {
                    try {
                        valorDouble = Double.parseDouble(valor.trim());
                        System.out.println(valorDouble);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("valor invalido");
                    }
                } else {
                    System.out.println("Erro ao cadastrar transferencia");
                }
                String data_trans = req.getParameter("dataTrans");
                String tipo_trans = req.getParameter("tipoTrans");

                System.out.println(nome_trans);
                System.out.println(valorDouble);
                System.out.println(data_trans);
                System.out.println(tipo_trans);

                try {
                    transferencias = new TransferenciaBuilder()
                            .setId_transferencia(5)
                            .setCd_conta(43)
                            .setValor_transferencia(valorDouble)
                            .setData_transferencia(new SimpleDateFormat("yyyy-MM-dd").parse(data_trans))
                            .setTipo_transferencia(tipo_trans)
                            .setNome_transferencia(nome_trans)
                            .build();
                } catch (ParseException e) {
                    throw new RuntimeException();
                }

                try {
                    transferencias.adicionarTransferencia();
                    req.setAttribute("transferencia", "Transferencia adicionada");
                    RequestDispatcher rd = req.getRequestDispatcher("transferencias.jsp");
                    rd.forward(req, resp);
                } catch (SQLException e) {
                    req.setAttribute("erro", e.getMessage());
                    RequestDispatcher rd = req.getRequestDispatcher("transferencias.jsp");
                    rd.forward(req, resp);
                    return;
                }

                break;


        }

    }

}



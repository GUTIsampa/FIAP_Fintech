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
        String view = req.getParameter("view");
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");
        String mostrarTrans = req.getParameter("mostrarTrans");
        boolean shouldForward = false;

        if ("saldo".equals(acao)) {
            Conta conta = new Conta();
            
            try {
                double saldoAtual = conta.buscarPorSaldo(cd_conta_sessao);
                req.setAttribute("saldoAtual", saldoAtual);
                shouldForward = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if ("viewFatura".equals(view)) {
            Transferencias tf = new Transferencias();
            try {
                List<Transferencias> listaTransferencias = tf.getLista(cd_conta_sessao);
                req.setAttribute("faturas", listaTransferencias);
                shouldForward = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (shouldForward) {
            RequestDispatcher rd = req.getRequestDispatcher("transferencias.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transferencias transferencias;
        Conta conta;
        String acao = req.getParameter("acao");
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");

        switch (acao) {
            case "cadastrarTrans":
                String nome_trans = req.getParameter("nomeTrans");
                String valor = req.getParameter("valTrans");
                double valorDouble = 0.0;
                int valorInt = 0;
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
                String cartaoTrans = req.getParameter("cartaoTrans");
                if (cartaoTrans != null && !cartaoTrans.trim().isEmpty()) {
                    try {
                        valorInt = Integer.parseInt(cartaoTrans.trim());
                        System.out.println(valorInt);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("valor invalido");
                    }

                    System.out.println(nome_trans);
                    System.out.println(valorDouble);
                    System.out.println(data_trans);
                    System.out.println(tipo_trans);
                    System.out.println(valorInt);

                    try {
                        transferencias = new TransferenciaBuilder()
                                .setValor_transferencia(valorDouble)
                                .setData_transferencia(new SimpleDateFormat("yyyy-MM-dd").parse(data_trans))
                                .setTipo_transferencia(tipo_trans)
                                .setNome_transferencia(nome_trans)
                                .setId_cartao(valorInt)
                                .build();
                    } catch (ParseException e) {
                        throw new RuntimeException();
                    }

                    try {
                        transferencias.adicionarTransferencia();
                        if (tipo_trans.equals("recebimento")) {
                            conta = new Conta();
                            conta = conta.buscaPorId(cd_conta_sessao);
                            conta.alterarSaldo(conta.getSaldo() + Double.parseDouble(valor));
                        } else if (tipo_trans.equals("pagamento")) {
                            conta = new Conta();
                            conta = conta.buscaPorId(cd_conta_sessao);

                            System.out.println(conta.getSaldo() - Double.parseDouble(valor));
                            conta.alterarSaldo(conta.getSaldo() - (Double.parseDouble(valor)));
                        }

                        req.setAttribute("transferencia", "Transferencia adicionada");

                        String redirectUrl = "transferencias?acao=saldo&view=viewFatura&id=" + cd_conta_sessao;
                        resp.sendRedirect(redirectUrl);

                    } catch (SQLException e) {
                        req.setAttribute("erro", e.getMessage());
                        return;
                    }

                    break;


                }

        }

    }
}



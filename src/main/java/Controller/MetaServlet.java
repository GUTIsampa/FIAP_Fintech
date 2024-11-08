package Controller;

import Impl.OracleMetaDAO;
import Model.Meta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Exception.DBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/metas")
public class MetaServlet extends HttpServlet {
    private OracleMetaDAO oracleMetaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        oracleMetaDAO = new OracleMetaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");
        String view = req.getParameter("mostrar");
        List<Meta> metas;


        if ("viewMetas".equals(view)) {
            try {
                metas = this.oracleMetaDAO.buscarMeta(cd_conta_sessao);




                req.setAttribute("metasDisponiveis", metas);
                RequestDispatcher rd = req.getRequestDispatcher("metas.jsp");
                rd.forward(req, resp);
            } catch (DBException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        HttpSession session = req.getSession(false);
        Integer cd_conta_sessao = (Integer) session.getAttribute("id");


        switch (acao) {
            case "add":
                String nomeMeta = req.getParameter("nomeMeta");
                Double valMeta = Double.parseDouble(req.getParameter("valMeta"));

                try {
                    Meta meta = new Meta( cd_conta_sessao,valMeta, nomeMeta );
                    meta.adicionarMeta();
                    req.setAttribute("meta", "Meta adicionada");
                    String redirectUrl = "metas?mostrar=viewMetas";
                    resp.sendRedirect(redirectUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "guardar":
                String valorAdicionar = req.getParameter("valGuardar");
                String metaId = req.getParameter("selectedMeta");
                int idmetaInt = Integer.parseInt(metaId);
                double valorAcrescentado = Double.parseDouble(valorAdicionar);

                try {
                    Meta meta = oracleMetaDAO.getMetabyId(idmetaInt);
                    double valorAtualMeta = meta.getValorFinalMeta();
                    double valorAtualizadoMeta = valorAcrescentado + valorAtualMeta;
                    meta.setValorFinalMeta(valorAtualizadoMeta);
                    meta.updateValorMeta(meta);
                    session.setAttribute("metaValor", valorAtualizadoMeta);
                    meta.setValorFinalMeta(valorAtualizadoMeta);
                    req.setAttribute("valor", "Meta atualizada");
                    String redirectUrl = "metas?mostrar=viewMetas";
                    resp.sendRedirect(redirectUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}

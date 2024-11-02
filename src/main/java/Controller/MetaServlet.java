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
                metas = this.oracleMetaDAO.buscarMeta(61);
                req.setAttribute("metas", metas);

                RequestDispatcher rd = req.getRequestDispatcher("metas.jsp");
                System.out.println(metas);
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


        switch (acao) {
            case "add":
                String nomeMeta = req.getParameter("nomeMeta");
                Double valMeta = Double.parseDouble(req.getParameter("valMeta"));

                try {
                    Meta meta = new Meta(4, 61, valMeta, nomeMeta );
                    meta.adicionarMeta();
                    req.setAttribute("meta", "Meta adicionada");
                    RequestDispatcher rd = req.getRequestDispatcher("metas.jsp");
                    rd.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "guardar":
                String valorGuardar = req.getParameter("valGuardar");
                String nomeGuardar = req.getParameter("nomeGuardar");

                try {
                    Meta meta = new Meta();
                    double valor = Double.parseDouble(valorGuardar);
                    meta.atualizarMeta(nomeGuardar, valor);
                    req.setAttribute("valor", "Meta atualizada");
                    RequestDispatcher rd = req.getRequestDispatcher("metas.jsp");
                    rd.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}

package Model;

import Impl.OracleFaturaDAO;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Exception.DBException;

public class Fatura {
    private Integer id_fatura;
    private Integer id_cartao;
    private Double vl_fatura;
    private Date vencimento_fatura;
    private String nm_fatura;

    public Fatura(Integer id_fatura, Integer id_cartao, Double vl_fatura, Date vencimento_fatura, String nm_fatura) {
        this.id_fatura = id_fatura;
        this.id_cartao = id_cartao;
        this.vl_fatura = vl_fatura;
        this.vencimento_fatura = vencimento_fatura;
        this.nm_fatura = nm_fatura;
    }

    public Fatura() {

    }

    public Integer getId_fatura() {
        return id_fatura;
    }

    public void setId_fatura(Integer id_fatura) {
        this.id_fatura = id_fatura;
    }

    public Integer getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(Integer id_cartao) {
        this.id_cartao = id_cartao;
    }

    public Double getVl_fatura() {
        return vl_fatura;
    }

    public void setVl_fatura(Double vl_fatura) {
        this.vl_fatura = vl_fatura;
    }

    public Date getVencimento_fatura() {
        return vencimento_fatura;
    }

    public void setVencimento_fatura(Date vencimento_fatura) {
        this.vencimento_fatura = vencimento_fatura;
    }

    public String getNm_fatura() {
        return nm_fatura;
    }

    public void setNm_fatura(String nm_fatura) {
        this.nm_fatura = nm_fatura;
    }


    public void adicionarFatura() throws DBException {
        OracleFaturaDAO oracleFaturaDAO = new OracleFaturaDAO();
        oracleFaturaDAO.cadastrar(this);
    }

    public void removerFatura(int codigo) throws DBException {
        OracleFaturaDAO oracleFaturaDAO = new OracleFaturaDAO();
        oracleFaturaDAO.excluir(codigo);
    }

    public void atualizarFatura() throws DBException {
        OracleFaturaDAO oracleFaturaDAO = new OracleFaturaDAO();
        oracleFaturaDAO.atualizar(this);
    }

    public void buscarFatura(int codigoFatura) throws DBException {
        OracleFaturaDAO oracleFaturaDAO = new OracleFaturaDAO();
        oracleFaturaDAO.buscar(codigoFatura);
    }

    public List<Fatura> listarFaturas() throws DBException {
        OracleFaturaDAO oracleFaturaDAO = new OracleFaturaDAO();
        return new ArrayList<Fatura>(oracleFaturaDAO.listar());
    }

    public static void main(String[] args) throws ParseException, DBException {
       /*Fatura fatura = new Fatura();
       fatura.removerFatura(1);*/

       /* Fatura fatura = new Fatura(2, 2, 2500.50, new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-24"), "Pagamento atualizado do cartão de crédito");
        fatura.atualizarFatura();*/

        /*Fatura fatura = new Fatura();
        fatura.buscarFatura(2);*/

        Fatura fatura = new Fatura();
        List<Fatura> faturaList = fatura.listarFaturas();
        for (Fatura f : faturaList) {
            System.out.println(f.getNm_fatura());
        }
    }
}

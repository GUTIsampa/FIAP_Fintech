package Model;

import DAO.CartaoDAO;
import DAO.ContaDAO;
import Impl.OracleCartaoDAO;
import Utils.CriptografiaUtils;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import Exception.DBException;


public class Cartao {
    private Integer cartao;
    private Integer conta;
    private String nr_cartao;
    private String bandeira;
    private Date vencimento;
    private String cd_seguranca;

    public Cartao( String nr_cartao, String bandeira, Date vencimento, String cd_seguranca) {

        setNr_cartao(nr_cartao);
        this.bandeira = bandeira;
        this.vencimento = vencimento;
        setCd_seguranca(cd_seguranca);
    }

    public Cartao() {

    }

    public Integer getCartao() {
        return cartao;
    }

    public void setCartao(Integer cartao) {
        this.cartao = cartao;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public String getNr_cartao() {
        return nr_cartao;
    }

    public void setNr_cartao(String nm_cartao) {
       try {
        this.nr_cartao = CriptografiaUtils.criptografarNumeroCartao(nm_cartao);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getCd_seguranca() {
        return cd_seguranca;
    }

    public void setCd_seguranca(String cd_seguranca) {
        try {
            this.cd_seguranca = CriptografiaUtils.criptografarCVV(cd_seguranca);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarCartao() throws DBException {
        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
        oracleCartaoDAO.cadastrar(this);
    }

    public void atualizarCartao() throws DBException {
        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
        oracleCartaoDAO.atualizar(this);
    }

    public void excluirCartao(int codigo) throws DBException {
        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
        oracleCartaoDAO.excluir(codigo);
    }

    public Cartao buscarCartao(int id) throws DBException {
        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
        return oracleCartaoDAO.buscar(id);
    }

    public List<Cartao> listarCartao() throws DBException {
        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
        return new ArrayList<Cartao>(oracleCartaoDAO.listar());
    }



    public static void main(String[] args) throws ParseException, DBException {

    // Cartao cartao = new Cartao("5555222233334449","Mastercard", new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-24"), "321");
        // cartao.adicionarCartao();

//        Cartao cartao = new Cartao("555522233331111","Visa", new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-24"), "321");
//        OracleCartaoDAO oracleCartaoDAO = new OracleCartaoDAO();
//        oracleCartaoDAO.atualizar(cartao);

//        Cartao cartao = new Cartao();
//        cartao.excluirCartao(1);

//       Cartao cartao = new Cartao();
//        List<Cartao> cartaoAchado = cartao.listarCartao();
//        for (Cartao c : cartaoAchado) {
//            System.out.println(c.getBandeira());
//        }
    }
}

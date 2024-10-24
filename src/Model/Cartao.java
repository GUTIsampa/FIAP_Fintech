package Model;
import Factory.ConnectionFactory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Cartao {
    private Integer cartao;
    private Integer conta;
    private String nr_cartao;
    private String bandeira;
    private Date vencimento;
    private Integer cd_seguranca;

    public Cartao(Integer cartao, Integer conta, String nr_cartao, String bandeira, Date vencimento, Integer cd_seguranca) {
        this.cartao = cartao;
        this.conta = conta;
        this.nr_cartao = nr_cartao;
        this.bandeira = bandeira;
        this.vencimento = vencimento;
        this.cd_seguranca = cd_seguranca;
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
        this.nr_cartao = nm_cartao;
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

    public Integer getCd_seguranca() {
        return cd_seguranca;
    }

    public void setCd_seguranca(Integer cd_seguranca) {
        this.cd_seguranca = cd_seguranca;
    }



    }

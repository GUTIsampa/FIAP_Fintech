package Model;

import java.util.Date;

public class CartaoBuilder {
    protected Integer cartao;
    protected Integer conta;
    protected String nr_cartao;
    protected String bandeira;
    protected Date vencimento;
    protected String cd_seguranca;
    protected String nome_cartao;

    public CartaoBuilder() {

    }

    public CartaoBuilder setNome_cartao(String nome_cartao) {
        this.nome_cartao = nome_cartao;
        return this;
    }

    public CartaoBuilder setCartao(Integer cartao) {
        this.cartao = cartao;
        return this;
    }

    public CartaoBuilder setConta(Integer conta) {
        this.conta = conta;
        return this;
    }

    public CartaoBuilder setNr_cartao(String nr_cartao) {
        this.nr_cartao = nr_cartao;
        return this;
    }

    public CartaoBuilder setBandeira(String bandeira) {
        this.bandeira = bandeira;
        return this;
    }

    public CartaoBuilder setVencimento(Date vencimento) {
        this.vencimento = vencimento;
        return this;
    }

    public CartaoBuilder setCd_seguranca(String cd_seguranca) {
        this.cd_seguranca = cd_seguranca;
        return this;
    }

    public Cartao build() {
        return new Cartao(this);
    }
}

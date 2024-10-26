package Model;

import java.util.Date;

public class ContaBuilder {
    protected int cd_conta;
    protected double nr_saldo;
    protected String id_email;
    protected Date dt_abertura;
    protected String st_conta;
    protected String senha;
    protected String nm_usuario;
    protected Date dt_nasc;

    public ContaBuilder() {
    }

    public ContaBuilder CdConta(int cd_conta) {
        this.cd_conta = cd_conta;
        return this;
    }

    public ContaBuilder NrSaldo(Double nr_saldo) {
        this.nr_saldo = nr_saldo;
        return this;
    }

    public ContaBuilder IdEmail(String id_email) {
        this.id_email = id_email;
        return this;
    }

    public ContaBuilder DtAbertura(Date dt_abertura) {
        this.dt_abertura = dt_abertura;
        return this;
    }

    public ContaBuilder StConta(String st_conta) {
        this.st_conta = st_conta;
        return this;
    }

    public ContaBuilder Senha(String senha) {
        this.senha = senha;
        return this;
    }

    public ContaBuilder NmUsuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
        return this;
    }

    public ContaBuilder DtNasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
        return this;
    }

    public ContaModel build() {
        this.dt_abertura = new Date();
        return new ContaModel(this);
    }
}

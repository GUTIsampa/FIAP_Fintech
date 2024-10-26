package Model;

import java.sql.Date;
import Utils.CriptografiaUtils;

public class Conta {
    Double saldo;
    String email;
    String senha;
    Date dt_abertura;
    String status_conta;
    String tipo_conta;
    String nomeUsuario;
    Date dt_nascimento;

    public Conta() {
        super();
    }

    public Conta(String email, String senha){
        this.email = email;
        setSenha(senha);


    }

    public Conta(Double saldo, String email, String senha, Date dt_abertura, String status_conta, String tipo_conta, String nomeUsuario) {
        super();
        this.saldo = saldo;
        this.email = email;
        this.dt_abertura = dt_abertura;
        this.status_conta = status_conta;
        this.tipo_conta = tipo_conta;
        this.nomeUsuario = nomeUsuario;
        setSenha(senha);
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getDt_abertura() {
        return dt_abertura;
    }

    public void setDt_abertura(Date dt_abertura) {
        this.dt_abertura = dt_abertura;
    }

    public String getStatus_conta() {
        return status_conta;
    }

    public void setStatus_conta(String status_conta) {
        this.status_conta = status_conta;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
}

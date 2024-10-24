package Model;

import java.sql.Date;

public class Conta {
    private Integer conta;
    private Double saldo;
    private String email;
    private Date data;
    private String status;
    private String tipo;

    public Conta(Double saldo, String email, Date data, String status, String tipo) {
        this.conta = conta;
        this.saldo = saldo;
        this.email = email;
        this.data = data;
        this.status = status;
        this.tipo = tipo;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

package Model;


import java.sql.Date;

public class Transferencias {
    private Integer id;
    private Integer conta;
    private String tipo;
    private Double valor;
    private Date data;

    public Transferencias(Integer id, Integer conta, String tipo, Double valor, Date data) {
        this.id = id;
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }
    public Transferencias() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = id;
    }
    public Integer getConta() {
        return conta;
    }
    public void setConta(Integer conta) {
        this.conta = conta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}
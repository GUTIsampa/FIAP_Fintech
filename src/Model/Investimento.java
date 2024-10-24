package Model;
import java.lang.Math;
import java.sql.Date;

public class Investimento {
    Integer investimento;
    Integer conta;
    String tp_investimento;
    Date data_investimento;
    Double vl_investido;
    Double vl_rendimento;

    public Investimento(Integer investimento, Integer conta, String tp_investimento, Date data_investimento, Double vl_investido, Double vl_rendimento ){
        this.investimento = investimento;
        this.conta = conta;
        this.tp_investimento = tp_investimento;
        this.data_investimento = data_investimento;
        this.vl_investido = vl_investido;
        this.vl_rendimento = vl_rendimento;
    }


    public Integer getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Integer investimento) {
        this.investimento = investimento;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public String getTp_investimento() {
        return tp_investimento;
    }

    public void setTp_investimento(String tp_investimento) {
        this.tp_investimento = tp_investimento;
    }

    public Date getData_investimento() {
        return data_investimento;
    }

    public void setData_investimento(Date data_investimento) {
        this.data_investimento = data_investimento;
    }

    public Double getVl_investido() {
        return vl_investido;
    }

    public void setVl_investido(Double vl_investido) {
        this.vl_investido = vl_investido;
    }

    public Double getVl_rendimento() {
        return vl_rendimento;
    }

    public void setVl_rendimento(Double vl_rendimento) {
        this.vl_rendimento = vl_rendimento;
    }

    public Double Rendimento(double vl_inicial, double porcentagem, int tempo) {
        double vl_rendimento = vl_inicial * Math.pow((1 + porcentagem), tempo);
        return vl_rendimento;
    }


}

package Model;

import java.sql.Date;

public class Fatura {
    private Integer id_fatura;
    private Integer id_cartao;
    private Double vl_fatura;
    private Date vencimento_fatura;
    private Date data_pagamento;

    public Fatura(Integer id_fatura, Integer id_cartao, Double vl_fatura, Date vencimento_fatura, Date data_pagamento) {
        this.id_fatura = id_fatura;
        this.id_cartao = id_cartao;
        this.vl_fatura = vl_fatura;
        this.vencimento_fatura = vencimento_fatura;
        this.data_pagamento = data_pagamento;
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

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
}

package Model;

import java.util.Date;

public class TransferenciaBuilder {
    protected int id_transferencia;
    protected int cd_conta;
    protected String tipo_transferencia;
    protected Date data_transferencia;
    protected Double valor_transferencia;
    protected String nome_transferencia;

    public TransferenciaBuilder() {

    }

    public TransferenciaBuilder setId_transferencia(int id_transferencia) {
        this.id_transferencia = id_transferencia;
        return this;
    }

    public TransferenciaBuilder setCd_conta(int cd_conta) {
        this.cd_conta = cd_conta;
        return this;
    }

    public TransferenciaBuilder setTipo_transferencia(String tipo_transferencia) {
        this.tipo_transferencia = tipo_transferencia;
        return this;
    }

    public TransferenciaBuilder setData_transferencia(Date data_transferencia) {
        this.data_transferencia = data_transferencia;
        return this;
    }

    public TransferenciaBuilder setValor_transferencia(Double valor_transferencia) {
        this.valor_transferencia = valor_transferencia;
        return this;
    }

    public TransferenciaBuilder setNome_transferencia(String nome_transferencia) {
        this.nome_transferencia = nome_transferencia;
        return this;
    }

    public Transferencias build() {
        return new Transferencias(this);
    }
}

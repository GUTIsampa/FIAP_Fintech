package Model;

import Impl.OracleMetaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Exception.DBException;

public class Meta {
    private Integer id_meta;
    private Integer cd_conta;
    private Double valor_meta;
    private String nome_meta;
    private double valorFinalMeta;

    public Meta(Integer id_meta, Integer cd_conta, Double valor_meta, String nome_meta) {
        this.id_meta = id_meta;
        this.cd_conta = cd_conta;
        this.valor_meta = valor_meta;

        this.nome_meta = nome_meta;
    }

    public Meta() {

    }

    @Override
    public String toString() {
        return "valor_meta - " + valor_meta +
                "nome_meta - " + nome_meta;
    }

    public Integer getId_meta() {
        return id_meta;
    }

    public void setId_meta(Integer id_meta) {
        this.id_meta = id_meta;
    }

    public Integer getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(Integer cd_conta) {
        this.cd_conta = cd_conta;
    }

    public Double getValor_meta() {
        return valor_meta;
    }

    public void setValor_meta(Double valor_meta) {
        this.valor_meta = valor_meta;
    }

    public String getNome_meta() {
        return nome_meta;
    }

    public void setNome_meta(String nome_meta) {
        this.nome_meta = nome_meta;
    }

    public double getValorFinalMeta() {
        return valorFinalMeta;
    }

    public void setValorFinalMeta(double valorFinalMeta) {
        this.valorFinalMeta = valorFinalMeta;
    }

    public void adicionarMeta() {
        OracleMetaDAO oracleMetaDAO = new OracleMetaDAO();
        oracleMetaDAO.cadastrar(this);
    }

    public void atualizarMeta(String nome, Double valor) throws DBException {
        OracleMetaDAO oracleMetaDAO = new OracleMetaDAO();
        oracleMetaDAO.atualizar(nome, valor);
    }

}

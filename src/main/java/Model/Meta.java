package Model;

import Impl.OracleMetaDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meta {
    private Integer id_meta;
    private Integer cd_conta;
    private Double valor_meta;
    private Date data_limite;
    private String nome_meta;

    public Meta(Integer id_meta, Integer cd_conta, Double valor_meta, Date data_limite, String nome_meta) {
        this.id_meta = id_meta;
        this.cd_conta = cd_conta;
        this.valor_meta = valor_meta;
        this.data_limite = data_limite;
        this.nome_meta = nome_meta;
    }

    public Meta() {

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

    public Date getData_limite() {
        return data_limite;
    }

    public void setData_limite(Date data_limite) {
        this.data_limite = data_limite;
    }

    public String getNome_meta() {
        return nome_meta;
    }

    public void setNome_meta(String nome_meta) {
        this.nome_meta = nome_meta;
    }

    public void adicionarMeta() {
        OracleMetaDAO oracleMetaDAO = new OracleMetaDAO();
        oracleMetaDAO.cadastrar(this);
    }

    public static void main(String[] args) throws ParseException {
        Meta meta = new Meta(1, 61, 10000.00, new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-23"), "Viagens fim de ano");
        meta.adicionarMeta();
    }
}

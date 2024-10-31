package Model;


import Impl.OracleContaDAO;
import Utils.CriptografiaUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    Integer cd_conta;
    Double saldo;
    String email;
    String senha;
    Date dt_abertura;
    String status_conta;
    String nomeUsuario;
    Date dt_nascimento;

    public Conta() {
        super();
    }

    public Conta(String email, String senha){
        this.email = email;
        setSenha(senha);


    }

    public Conta(Double saldo, String email, String senha, Date dt_abertura, String status_conta, String nomeUsuario) {
        super();
        this.saldo = saldo;
        this.email = email;
        this.dt_abertura = dt_abertura;
        this.status_conta = status_conta;
        this.nomeUsuario = nomeUsuario;
        setSenha(senha);
    }

    public Conta(ContaBuilder contaBuilder) {
        this.saldo = contaBuilder.nr_saldo;
        this.cd_conta = contaBuilder.cd_conta;
        this.email = contaBuilder.id_email;
        setSenha(contaBuilder.senha);
        this.dt_abertura = contaBuilder.dt_abertura;
        this.status_conta = contaBuilder.st_conta;
        this.nomeUsuario = contaBuilder.nm_usuario;
        this.dt_nascimento = contaBuilder.dt_nasc;
    }

    public Integer getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(Integer cd_conta) {
        this.cd_conta = cd_conta;
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

    public void cadastrarConta(Conta builder) throws SQLException {
        try{
            OracleContaDAO contaDao = new OracleContaDAO();
            contaDao.cadastrar(builder);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Conta buscaPorId(int id) throws SQLException {
        OracleContaDAO contaDao = new OracleContaDAO();
        return contaDao.buscarPorId(id);

    }

    public Conta buscarPorEmail(String email) throws SQLException {
        OracleContaDAO contaDao = new OracleContaDAO();
        return contaDao.buscarPorEmail(email);

    }

    public void excluirPorId(int id) throws SQLException {
        OracleContaDAO contaDao = new OracleContaDAO();
        contaDao.exluirPorId(id);
    }
    public void alterar() throws SQLException {
        OracleContaDAO contaDao = new OracleContaDAO();
        contaDao.alterar(this);
    }

    public List<Conta> getAll() throws SQLException {
        OracleContaDAO contaDAO = new OracleContaDAO();
        return contaDAO.getAll();
    }

    public static void main(String[] args) throws SQLException, ParseException {
        Conta conta = new Conta();
        //Conta builder = new ContaBuilder().IdEmail("asdas@gmail.com").StConta("Ativo").DtNasc(new SimpleDateFormat("yyyy-MM-dd").parse("2001-04-29")).Senha("1234587").NmUsuario("OutroTeste").build();
        List<Conta> contas = conta.getAll();
        for (Conta conta1 : contas) {
            System.out.println(conta1.getNomeUsuario());
        }

      /*  Conta cuenta = conta.buscaPorId(47);
        System.out.println(cuenta.getEmail());*/

          }

}

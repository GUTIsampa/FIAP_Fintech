
package Model;
import DAO.PerfilDAO;
import DAO.PerfilDAO;
import Impl.OraclePerfilDAO;
import Utils.CriptografiaUtils;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import Exception.DBException;

public class Perfil {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private double saldo;



    public Perfil() {
    }


    public Perfil(int id, String nome, String email, String senha, double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}


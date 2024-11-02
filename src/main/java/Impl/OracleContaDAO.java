package Impl;

import DAO.ConnectionManager;
import DAO.ContaDAO;
import Model.Conta;
import Model.ContaBuilder;
import Utils.CriptografiaUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class OracleContaDAO implements ContaDAO {
    private Connection con;

    public Connection abrirConexao(){
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        return connectionManager.getConnection();

    }

    public String validarUsuario(Conta conta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager
                    .getInstance()
                    .getConnection();

            String sql = "select * from t_conta where id_email = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, conta.getEmail());
            rs = ps.executeQuery();
            System.out.println(conta.getEmail());
            System.out.println(conta.getSenha());
            if (!rs.next()) {
                return "Conta inexistente";
            }

            rs.close();
            ps.close();

            String sqlSenha = "select * from t_conta where id_email = ? and senha = ? ";
            ps = con.prepareStatement(sqlSenha);
            ps.setString(1, conta.getEmail());
            ps.setString(2, conta.getSenha());
            rs = ps.executeQuery();

            if (!rs.next()) {
                return "Senha incorreta";
            }

            return "Autenticação bem sucedida";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Erro ao autenticar";
    }

    public void cadastrar(Conta conta) throws SQLException {
        Connection conectar = abrirConexao();
        Conta email = buscarPorEmail(conta.getEmail());
        if (email == null) {
            String sql = "INSERT INTO t_conta (nr_saldo, id_email, st_conta, senha, nm_usuario, dt_abertura, dt_nasc) VALUES (0,?, ?, ?, ?,?,?)";



            try{
                PreparedStatement stm = conectar.prepareStatement(sql);

                stm.setString(1, conta.getEmail());
                stm.setString(2, "ativo");
                stm.setString(3, conta.getSenha());
                stm.setString(4, conta.getNomeUsuario());
                Date dt_abertura = new Date(conta.getDt_abertura().getTime());
                //Convertendo para java.sql.Date
                stm.setDate(5, dt_abertura);
                // Para a data de nascimento
                Date dt_nasc = new Date(conta.getDt_nascimento().getTime());
                stm.setDate(6, dt_nasc);
                stm.executeUpdate();
                conectar.close();

            } catch (SQLException e) {

                e.getMessage();
                throw new RuntimeException(e);
            }
        }
    }
    public Conta buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM T_conta WHERE cd_conta = ?";
        Conta conta = null;

        Connection conectar = this.abrirConexao();
        PreparedStatement stm = conectar.prepareStatement(sql);

        stm.setInt(1, id);
        try (ResultSet resultado = stm.executeQuery()) {
            if (resultado.next()) {
                ContaBuilder contaBuilder = new ContaBuilder();
                conta = new ContaBuilder()
                        .CdConta(resultado.getInt("cd_conta"))
                        .NrSaldo(resultado.getDouble("nr_saldo"))
                        .IdEmail(resultado.getString("id_email"))
                        .DtAbertura(resultado.getDate("dt_abertura"))
                        .StConta(resultado.getString("st_conta"))
                        .Senha(resultado.getString("senha"))
                        .NmUsuario(resultado.getString("nm_usuario"))
                        .DtNasc(resultado.getDate("dt_nasc"))
                        .build();
            }
        }

        return conta;
    }

    public Conta buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM T_conta WHERE id_email = ?";
        Conta conta = null;

        Connection conectar = this.abrirConexao();
        PreparedStatement stm = conectar.prepareStatement(sql);

        stm.setString(1, email);
        try (ResultSet resultado = stm.executeQuery()) {
            if (resultado.next()) {
                ContaBuilder contaBuilder = new ContaBuilder();
                conta = new ContaBuilder()
                        .CdConta(resultado.getInt("cd_conta"))
                        .NrSaldo(resultado.getDouble("nr_saldo"))
                        .IdEmail(resultado.getString("id_email"))
                        .DtAbertura(resultado.getDate("dt_abertura"))
                        .StConta(resultado.getString("st_conta"))
                        .Senha(resultado.getString("senha"))
                        .NmUsuario(resultado.getString("nm_usuario"))
                        .DtNasc(resultado.getDate("dt_nasc"))
                        .build();
            }
        }
        return conta;
    }

    public List<Conta> getAll() {
        List<Conta> contas = new ArrayList<Conta>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conectar = this.abrirConexao();
            String sql = "SELECT * FROM t_conta";
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("cd_conta");
                String email = rs.getString("id_email");
                String senha = rs.getString("senha");
                String nomeUsuario = rs.getString("nm_usuario");
                Date dt_abertura = rs.getDate("dt_abertura");
                Date dt_nasc = rs.getDate("dt_nasc");

                Conta novaConta = new ContaBuilder()
                        .CdConta(id)
                        .IdEmail(email)
                        .Senha(senha)
                        .NmUsuario(nomeUsuario)
                        .DtAbertura(dt_abertura)
                        .DtNasc(dt_nasc)
                        .build();

                contas.add(novaConta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contas;
    }

    public void exluirPorId(int id) throws SQLException {
        String sql = "delete FROM T_conta WHERE cd_conta = ?";
        Connection conectar = this.abrirConexao();
        PreparedStatement stm = conectar.prepareStatement(sql);

        stm.setInt(1, id);
        try{
            stm.executeQuery();
        }catch(SQLException e){
            e.getMessage();
        }

    }
    public void alterar(Conta conta) throws SQLException {
        Connection conectar = this.abrirConexao();
        String sql = "update T_conta set nr_saldo = , id_email = , st_conta = , senha = , nm_usuario = , dt_abertura = , dt_nasc =  where cd_conta = ";


        try {

            PreparedStatement stm = conectar.prepareStatement(sql);
            stm.setDouble(1, conta.getSaldo());
            stm.setString(2, conta.getEmail());
            stm.setString(3, conta.getStatus_conta());
            stm.setString(4, conta.getSenha());
            stm.setString(5, conta.getNomeUsuario());
            //Para pegar a data atual
            java.sql.Date dt_abertura = new java.sql.Date(conta.getDt_abertura().getTime());
            //Convertendo para java.sql.Date
            stm.setDate(6, dt_abertura);
            //Para a data de nascimento
            Date dt_nasc = new java.sql.Date(conta.getDt_nascimento().getTime());
            stm.setDate(7, dt_nasc);
            stm.setInt(8, conta.getCd_conta());

            stm.executeQuery();

            conectar.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarSaldo(Conta conta) throws SQLException {
        String sql = "update T_conta set nr_saldo = ? where cd_conta = ?";
        Connection conectar = this.abrirConexao();


        try {
            PreparedStatement stm = conectar.prepareStatement(sql);
            stm.setDouble(1, conta.getSaldo());
            stm.setDouble(2, conta.getCd_conta());
            stm.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public double GetSaldoConta(int cd_conta) throws SQLException {
        Connection conectar = this.abrirConexao();
        double saldo = 0.0;
        String sql = "select nr_saldo from T_conta where cd_conta = ?";

        try {
            PreparedStatement stm = conectar.prepareStatement(sql);
            stm.setInt(1, cd_conta);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                saldo = rs.getDouble("nr_saldo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saldo;
    }


}

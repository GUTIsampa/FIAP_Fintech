package DAO;

import Model.Cartao;
import Exception.DBException;

import java.util.List;

public interface CartaoDAO {
    void cadastrar(Cartao cartao) throws DBException;
    void atualizar(Cartao cartao) throws DBException;
    void excluir(int codigo) throws DBException;
    Cartao buscar(int id);
    List<Cartao> listar();

}

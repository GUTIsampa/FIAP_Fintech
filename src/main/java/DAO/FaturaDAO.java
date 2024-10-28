package DAO;

import Model.Cartao;
import Model.Fatura;
import Exception.DBException;
import java.util.List;

public interface FaturaDAO {
    void cadastrar(Fatura fatura) throws DBException;
    void atualizar(Fatura fatura) throws DBException;
    void excluir(int codigo) throws DBException;
    Cartao buscar(int id);
    List<Cartao> listar();
}

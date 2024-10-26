package Factory;

import DAO.ContaDAO;
import Impl.OracleContaDAO;

public class DaoFactory {

    public static ContaDAO getContaDAO() {
        return new OracleContaDAO();
    }
}

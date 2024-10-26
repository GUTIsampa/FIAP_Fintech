package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {
    public static String criptografar(String senha)  throws Exception {
        // Obtém a instância de um algoritmo
        MessageDigest md = MessageDigest.getInstance("MD5");

        //Passa os dados a serem criptografados
        md.update(senha.getBytes("ISO-8859-1"));

        //Gera a chave criptografada
        BigInteger hash = new BigInteger(1, md.digest());

        //Retorna a senha criptografada
        return hash.toString(16);
    }

   /*public static void main(String[] args) {
        try {
            System.out.println(CriptografiaUtils.criptografar("1245"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {
<<<<<<< Updated upstream
=======

    //Metodo que criptografa a senha do usuário
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

   /*public static void main(String[] args) {
        try {
            System.out.println(CriptografiaUtils.criptografar("1245"));
        } catch (Exception e) {
=======
    //metodo que criptografa o numero do cartao debito/credito
    public static String criptografarDado(String dado)  throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(dado.getBytes("ISO-8859-1"));
        BigInteger hash = new BigInteger(1, md.digest());
        return hash.toString(16);
    }

    // Metodo específico para criptografar o número do cartão
    public static String criptografarNumeroCartao(String numeroCartao) throws Exception {
        return criptografar(numeroCartao);
    }

    // Metodo específico para criptografar o CVV
    public static String criptografarCVV(String cvv) throws Exception {
        return criptografar(cvv);
    }

    /*public static void main(String[] args) {
        try {
            String numeroCartao = "1234567812345678";
            String cvv = "123";

            // Criptografando o número do cartão separadamente
            String cartaoCriptografado = criptografarNumeroCartao(numeroCartao);
            System.out.println("Número do Cartão Criptografado: " + cartaoCriptografado);

            // Criptografando o CVV separadamente
            String cvvCriptografado = criptografarCVV(cvv);
            System.out.println("CVV Criptografado: " + cvvCriptografado);

            // Concatenando as criptografias (opcional)
            String cartaoCvvConcatenado = cartaoCriptografado + ":" + cvvCriptografado;
            System.out.println("Concatenado: " + cartaoCvvConcatenado);

        }  catch (Exception e) {
>>>>>>> Stashed changes
            e.printStackTrace();
        }
    }*/
}
<<<<<<< Updated upstream
=======



>>>>>>> Stashed changes

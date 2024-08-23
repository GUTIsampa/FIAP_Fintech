

// A CLASSE ENDEREÇO ESTÁ SENDO VALIDADA NA CLASSE "CADASTRO"

// A CLASSE ENDERECO ESTÁ SENDO UTILZIADA PARA ARMAZENAR OS PARÂMETROS ESSENCIAIS

public class Endereco {
    private String logradouro;
    private int numero;
    private String bairro;
    private int cep;

    public Endereco () {

    }

    public Endereco (String logradouro, int numero, String bairro, int cep){
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

}

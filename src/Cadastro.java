import java.util.Scanner;

public class Cadastro {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;

    public Cadastro () {}

    public Cadastro (String nome, String cpf, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;
        Cadastro cadastro = null;

        do {
            System.out.println("1 - Cadastrar usuário \n 2 - Exibir \n 3 - Sair");
            op = sc.nextInt();

            // inserindo informações do usuário
            switch (op) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    String nome = sc.next() + sc.nextLine();
                    System.out.println("Digite seu cpf: ");
                    String cpf = sc.next() + sc.nextLine();
                    System.out.println("Digite seu email: ");
                    String email = sc.next() + sc.nextLine();
                    System.out.println("Digite seu telefone: ");
                    String telefone = sc.next() + sc.nextLine();
                    System.out.println("Digite seu logradouro: ");
                    String logradouro = sc.next() + sc.nextLine();
                    System.out.println("Digite o numero: ");
                    int numero = sc.nextInt();
                    System.out.println("Digite seu bairro: ");
                    String bairro = sc.next() + sc.nextLine();
                    System.out.println("Digite seu cep: ");
                    int cep = sc.nextInt();

                    // instanciando objeto com as informações inseridas

                    Endereco endereco = new Endereco(logradouro, numero, bairro, cep);
                    cadastro = new Cadastro(nome, cpf, email, telefone, endereco);

                    System.out.println("Cadastro realizado.");
                    break;

                case 2:
                    //exibindo informações

                    if (cadastro != null) {
                        System.out.println("Nome:" + cadastro.getNome() + "|| cpf: " + cadastro.getCpf());
                        System.out.println("=====================================");
                        System.out.println("email: " + cadastro.getEmail() + " || telefone: " + cadastro.getTelefone());
                        System.out.println("=====================================");
                        System.out.println("Logradouro: " + cadastro.getEndereco().getLogradouro() + " || numero: " + cadastro.getEndereco().getNumero());
                        System.out.println("=====================================");
                        System.out.println("cep: " + cadastro.getEndereco().getCep());
                        break;
                    }
            }

        } while (op != 3); {
            System.out.println("você saiu.");
            sc.close();
        }

    }

}

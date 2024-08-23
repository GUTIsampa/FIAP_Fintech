public class Pagamento {
    double valor;
    String dataPagamento;
    boolean pagamentoFixo;
    String destinatario;

    public Pagamento () {

    }

    public Pagamento(double valor, String dataPagamento, boolean pagamentoFixo, String destinatario) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.pagamentoFixo = pagamentoFixo;
        this.destinatario = destinatario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataRecebimento) {
        this.dataPagamento = dataRecebimento;
    }

    public boolean isPagamentoFixo() {
        return pagamentoFixo;
    }

    public void setPagamentoFixo(boolean pagamentoFixo) {
        this.pagamentoFixo = pagamentoFixo;
    }

    public String getRemetente() {
        return destinatario;
    }

    public void setRemetente(String remetente) {
        this.destinatario = destinatario;
    }

    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento(200, "19/08/2024", true, "Augustin");
        System.out.println("Novo pagamento realizado");
        System.out.println("==========================================");
        System.out.println("Valor: " + pagamento.getValor());
        System.out.println("==========================================");
        System.out.println("Data: " + pagamento.getDataPagamento());
        System.out.println("==========================================");
        System.out.println("É fixo? " + pagamento.isPagamentoFixo());
        System.out.println("==========================================");
        System.out.println("Remetente: " + pagamento.getRemetente());
    }
}

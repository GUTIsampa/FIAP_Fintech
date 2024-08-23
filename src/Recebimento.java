public class Recebimento {
    double valor;
    String dataRecebimento;
    boolean recebimentoFixo;
    String remetente;

    public Recebimento () {

    }

    public Recebimento (double valor, String dataRecebimento, boolean recebimentoFixo, String remetente) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.recebimentoFixo = recebimentoFixo;
        this.remetente = remetente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public boolean isRecebimentoFixo() {
        return recebimentoFixo;
    }

    public void setRecebimentoFixo(boolean recebimentoFixo) {
        this.recebimentoFixo = recebimentoFixo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public static void main(String[] args) {
        Recebimento recebimento = new Recebimento(2000.45,"12/10/2024", false, "Fernandin");
        System.out.println("Nova transferência recebida");
        System.out.println("==========================================");
        System.out.println("Valor: " + recebimento.getValor());
        System.out.println("==========================================");
        System.out.println("Data: " + recebimento.getDataRecebimento());
        System.out.println("==========================================");
        System.out.println("É fixo? " + recebimento.isRecebimentoFixo());
        System.out.println("==========================================");
        System.out.println("Remetente: " + recebimento.getRemetente());
    }
}

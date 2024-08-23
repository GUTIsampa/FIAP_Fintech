public class Cartao {
   String numCartao;
   String dataVencimento;
   String bandeira;

   public Cartao () {

   }

   public Cartao (String numCartao, String dataVencimento, String bandeira) {
      this.numCartao = numCartao;
      this.dataVencimento = dataVencimento;
      this.bandeira = bandeira;
   }

   public String getNumCartao() {
      return numCartao;
   }

   public void setNumCartao(String numCartao) {
      this.numCartao = numCartao;
   }

   public String getDataVencimento() {
      return dataVencimento;
   }

   public void setDataVencimento(String dataVencimento) {
      this.dataVencimento = dataVencimento;
   }

   public String getBandeira() {
      return bandeira;
   }

   public void setBandeira(String bandeira) {
      this.bandeira = bandeira;
   }

   public static void main(String[] args) {
      Cartao cartao = new Cartao("1234.5678.1234.5123", "12/01/2030", "Mastercard" );
      System.out.println("Cartão adicionado!");
      System.out.println("===============================================");
      System.out.println(cartao.getNumCartao());
      System.out.println(cartao.getDataVencimento());
      System.out.println(cartao.getBandeira());

   }

}




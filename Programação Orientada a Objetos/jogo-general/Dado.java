public class Dado {
    
    private final int MAX = 6;
    private int ladoCima; //pra testar mudar para publico 
    public Dado(){
        this.ladoCima = 1;
    }
    public void rolar(){
        this.ladoCima = (int)(Math.random() * MAX)+1;
    }
     public int getLadoCima(){
         return ladoCima;
    }
      public String toString(){
         return ""+ladoCima;
    }
}
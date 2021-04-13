package analisador;

public class ErroLexico extends Erro{
     /**
      * Implementacao do metodo abstrato, que retorna, o erro e a linha que contem o erro
      * @return 
      */
    @Override
    public String toString(){
        return "Erro Lexico: " + getPalavra() + "  na linha: " + getNlinha();
    }
}

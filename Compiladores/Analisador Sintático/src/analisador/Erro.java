package analisador;

import java.util.ArrayList;
import java.util.List;
 
public abstract class Erro {
    private String palavra;
    private int nLinha;
    private static final List<Erro> erros = new ArrayList(); // Criacao de um ArrayList para armazenar os erros    
    
    @Override
    public abstract String toString();
    
    public static final void addErro(Erro erro){
        Erro.erros.add(erro);
    }
    
    public static final void limparErros(){
        Erro.erros.clear();
    }

    public String getPalavra(){
        return palavra;
    }
    
    public void setPalavra(String palavra){
        this.palavra = palavra;
    }
    
    public int getNlinha() {
        return nLinha;
    }

    public void setNlinha(int nLinha) {
        this.nLinha = nLinha;
    }

    public static List<Erro> getErro() {
        return erros;
    }
}
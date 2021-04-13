package analisador;

import java.util.ArrayList;
import java.util.List;
 
public class Tokens {
    private String nome;
    private static final List<Tokens> tabelaTokens = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void addToken(Tokens token) {
        if (!Tokens.tabelaTokens.contains(token))
            Tokens.tabelaTokens.add(token);
    }

    public static List<Tokens> getTabelaDeTokens() {
        return tabelaTokens;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
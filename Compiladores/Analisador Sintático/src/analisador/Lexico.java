package analisador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Lexico {
    private BufferedReader codigoFonte;
    private String linha;
    private String caractere;
    private String palavra = "";
    private boolean comentario = false;
    private String numerica;
    private String identificador;
    private final ArrayList operadores = new ArrayList();
    private final ArrayList reservadas = new ArrayList();
    private final ArrayList<Item> tokens = new ArrayList();
    
    public Lexico(String pathFile){
        try {
            numerica = ("^\\d+|^\\d+");
            identificador = ("^\\D\\W+|^\\D+$");
            
            operadores.add("+");
            operadores.add("-");
            operadores.add("*");
            operadores.add("/");
            operadores.add(">");
            operadores.add(":=");
            
            //adiciona as palavras reservadas ao ArrayList
            reservadas.add("if");
            reservadas.add("then");
            reservadas.add("else");
            reservadas.add("end");
            reservadas.add("repeat");
            reservadas.add("until");
            reservadas.add("read");
            reservadas.add("write");
            
            codigoFonte = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
    }
    
    public void analisar() throws IOException{
        int nLinha = 0;
        while (true){
            nLinha++;

            linha = codigoFonte.readLine();
            if (linha == null)
                break;
            
            int size = linha.length();
            linha = linha.split("\r")[0];
            caractere = "";

            
            for (int i = 0; i < size;i++){ // Percorre as linhas enquanto houver
                caractere = linha.substring(i,i+1);
                if (" ".contains(caractere)){ // Identifica se existem comentarios
                     if ((!comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals(
                        "//"))){
                        palavra = "";
                        break;
                     }
                     if ((!comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals(
                        "/*"))){
                        palavra = "";
                        comentario = true;
                     }
                     if ((comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals(
                        "*/"))){
                        palavra = "";
                        comentario = false;
                     }
                     if ((!comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals(
                        "{"))){
                        palavra = "";
                        comentario = true;
                     }
                     if ((comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals(
                        "}"))){
                        palavra = "";
                        comentario = false;
                     }
                    if (!comentario){ 
                        if ((!palavra.equals("")) && (!palavra.contains("/*")))
                            this.addToken(palavra,nLinha);

                        //alinhar o token correspondente
                    }
                        palavra = "";
                }
                else
                    palavra = palavra + caractere;
            }            
        }
    }

    private void addToken(String palavra,int nLinha) {
        
        if (palavra.matches(numerica)){
            Item elemento = new Item();
            elemento.setToken("NUM");
            elemento.lexemaToken();
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
                   
        if (reservadas.contains(palavra)){
            Item elemento = new Item();
            elemento.lexemaToken();
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        
        if (operadores.contains(palavra)){
            Item elemento = new Item();
            elemento.setToken("OP");
            elemento.lexemaToken();
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        
        if (reservadas.contains(palavra)){
            Item elemento = new Item();
            elemento.setToken(palavra);
            tokens.add(elemento);
            return;
        }
        if(!palavra.equals(reservadas)){
            if (palavra.matches(identificador)){
                Item elemento = new Item();
                elemento.setToken("ID");
                elemento.lexemaToken();
                elemento.setLexema(palavra);
                tokens.add(elemento);
                Tokens simbolo = new Tokens();
                simbolo.setNome(palavra);
                Tokens.addToken(simbolo);
                return;
            }            
        }
        Erro erro = new ErroLexico();
        erro.setPalavra(palavra);
        erro.setNlinha(nLinha);
        Erro.addErro(erro);            
    }
    
    public ArrayList<Item> getToken(){
        return tokens;
    }
    public List<Item> getTokens(){
        return tokens;
    }
}
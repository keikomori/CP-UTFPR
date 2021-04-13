/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keiko
 */
public class Lexico {
    private BufferedReader codigo;
    private String linha;
    private String palavra = "";
    private String caractere;
    private boolean comentario = false;
    
    private String numero;
    private String identificador;
    private String numeroInv;
    
    private ArrayList reservadas = new ArrayList();
    private ArrayList<Item> tokens = new ArrayList();
    private ArrayList simbolo = new ArrayList();
    
    private String nomeArquivo;
    public Lexico(String nomeArquivo){
        try{
            this.nomeArquivo = nomeArquivo;
            
            numero = ("^\\d+\\d?$");
            identificador = ("^\\D+\\d?$");
                      
            numeroInv = ("^\\d.\\d+?$");
            
            //adiciona as palavras ao ArrayList
            reservadas.add("if");
            reservadas.add("then");
            reservadas.add("else");
            reservadas.add("end");
            reservadas.add("repeat");
            reservadas.add("until");
            reservadas.add("read");
            reservadas.add("write");
            
            simbolo.add("+");
            simbolo.add("-");
            simbolo.add("*");
            simbolo.add("/");
            simbolo.add("=");
            simbolo.add("<");
            simbolo.add("(");
            simbolo.add(")");
            simbolo.add(";");
            simbolo.add(":=");          
                        
            
            codigo = new BufferedReader(new FileReader(nomeArquivo));
        }catch (FileNotFoundException e){
            System.out.println("Erro ao abrir arquivo...");
        }        
    }
    /**
     * Percorre o texto de entrada identificando os tokens
     * @throws IOException 
     */
    public void analisar() throws IOException{
        Integer nLinha = 0;
        while(true){
            nLinha++;
            
            //le a linha
            linha = codigo.readLine();
            if (linha == null)
                break;
            
            int tam = linha.length();
            //quebra as strings em substrings
            linha = linha.split("\r")[0];
            caractere = "";
            
            for (int i=0; i<tam; i++){
                caractere = linha.substring(i, i+1);
                if(" ".contains(caractere)){
                    if ((!comentario) && (palavra.length() >= 1) && (palavra.substring(0,1).equals("{"))){
                        palavra = "";
                        comentario = true;
                    }
                    //se a palavra tem tamanho maior igual a 1
                    if ((comentario) && (palavra.length() >= 1) && (palavra.substring(0, 1).equals("}"))){
                        palavra = "";
                        comentario = false;
                    }
                    if ((!comentario) && ((!palavra.equals(""))&&(!palavra.contains("}")))){
                        this.adicionaToken(palavra);
                    }
                    palavra = "";                    
                }else
                        palavra = palavra + caractere;
            }
        }
    }
    private void adicionaToken(String palavra){
        //se a palavra for igual ao numero entao retorna o numero
        if(palavra.matches(numero)){
            Item item = new Item();
            item.setToken("NUM");
            item.setLexema(palavra);
            tokens.add(item);
            return;
        }
        //para numeros invalidos
        if(palavra.matches(numeroInv)){
            Item item = new Item();
            item.setToken("NUM INV");
            item.setLexema(palavra);
            tokens.add(item);
            return;
        }
        //para palavras reservadas
        if(reservadas.contains(palavra)){
            Item item = new Item();
            item.setToken(palavra.toUpperCase());
            item.setLexema(palavra);
            tokens.add(item);
            return;
        }
        //para operadores
        if(simbolo.contains(palavra)){
            Item item = new Item();
            item.setToken("OP");
            item.setLexema(palavra);
            tokens.add(item);
            return;
        }
        //para identificadores
        if ((!palavra.equals(reservadas) && (palavra.matches(identificador)))){
            Item item = new Item();
            item.setToken("ID");
            item.setLexema(palavra);
            tokens.add(item);
            return;
        }
    }
    //adiciona ao ArrayList os tokens 
    public List<Item> getToken(){
        return tokens;
    }
}

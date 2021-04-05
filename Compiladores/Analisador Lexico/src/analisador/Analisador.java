package analisador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Analisador {

    public static void main(String[] args) {
        Lexico analisador = new Lexico("entrada.txt");
        
        try {
            analisador.analisar();
            System.out.println("Analise Lexica:\n");
            System.out.println("<token,lexema> \n"+ analisador.getTokens());
            System.out.println("\nErros léxicos:\n");
            int i;
            for (i = 0; i < Erro.getErro().size();i++){
                Erro erro = Erro.getErro().get(i);      
                System.out.println(erro.toString());
            }
             /**
             * Gravando a saida do léxico em arquivo para servir de entrada
             * para o analisador sintatico
             */ 
            if (Erro.getErro().isEmpty()){
                System.out.println("\n  - Nao existem erros lexicos.\n");
            }
            String conteudo = "";
            File file = new File("entradaSintatico.txt"); //cria o arquivo

            conteudo = analisador.getTokens().toString();
            conteudo = conteudo.replace(", ", " ");
            conteudo = conteudo.replace("[", "");
            conteudo = conteudo.replace("]", " $");

            System.out.println("\nAnalise Sintatica:\n");
            
            if (Erro.getErro().isEmpty()){
                System.out.println("\nAceite\n");
            }
            Sintatico sintatico = new Sintatico(conteudo);
            
            sintatico.Imprime();            
                    
            if (!file.exists()) {
                file.createNewFile();
            }
            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
             
            // Escreve e fecha arquivo
            bw.write(conteudo);
            bw.close();           
            
        } catch (IOException ex) {
            System.out.println("Falha ao ler o arquivo.");
        }
    }
}

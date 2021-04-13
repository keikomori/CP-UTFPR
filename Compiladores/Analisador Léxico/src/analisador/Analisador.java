/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Keiko
 */
public class Analisador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Lexico lexico = new Lexico("teste1.txt");
        
        try{
            lexico.analisar();
            System.out.println("Arquivo lido...");
            System.out.println(lexico.getToken());   
            
        }catch (IOException e){
            System.out.println("Erro ao abrir arquivo...");
        }
    }
}

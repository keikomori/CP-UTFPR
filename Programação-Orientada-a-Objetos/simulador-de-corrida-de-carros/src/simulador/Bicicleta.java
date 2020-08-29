/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author Keiko-PC
 */
public class Bicicleta extends Veiculo {
    
    private static final Integer qtdeMovimento = 1; //esta variavel guarda a informacao da quantidade de tracos que a bicicleta se move
    
    public Bicicleta() {
        super("B", 2);
    }
   
    
    @Override
    void mover() {
        if(super.getCalibragem()){
            super.setDistanciaPercorrida(qtdeMovimento);
        }
        
    }

    @Override
    String imprimirTragetoria() {
        String tragetoria = "|";
        Integer aux = 0, auxk  = 0;
        for( int i = 0; i < super.getDistanciaPercorrida(); i++ ){
            tragetoria += "-";
            aux = aux + 1;
        } 
        auxk = aux;
        tragetoria += super.getId();
        return tragetoria + " " + auxk;
    }

    @Override
    public String toString() {
        return "Bicicleta: " + super.toString();
    }
}

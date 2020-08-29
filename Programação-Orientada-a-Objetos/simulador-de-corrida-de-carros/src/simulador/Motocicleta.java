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
public class Motocicleta extends VeiculoMotorizado{

    private static final Double consumo = 0.5d;
    private static final Integer qtdeMovimento = 3;
    private static final Double capacidadeTanque = 20d;
    
    public Motocicleta() {
        super("M", 2);
    }

    @Override
    void abastecer(Double litros) {
        if(litros <= capacidadeTanque){
            if(super.getCombustivel() <= capacidadeTanque){
                Double abastecer = super.getCombustivel()+litros;
               if(abastecer <= capacidadeTanque){
                   super.setCombustivel(abastecer);
               }
               else{
                   super.setCombustivel(capacidadeTanque);
               }
            }
        }
    }

    @Override
    void mover() {
        if(super.getCalibragem()){
            if(super.getCombustivel() >= consumo){
                super.setDistanciaPercorrida(qtdeMovimento);
                super.setCombustivel(super.getCombustivel() - consumo);
            }
        }
    }

    
    @Override
    String imprimirTragetoria() {
        String tragetoria = "|";
        for( int i = 0; i < super.getDistanciaPercorrida(); i++ ){
            tragetoria += "-";
        } 
        tragetoria += super.getId();
        return tragetoria;
    }

    @Override
    public String toString() {
        return "Motocicleta: " + super.toString();
    }
    
    
    
}

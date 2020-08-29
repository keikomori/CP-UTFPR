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
public class Ferrari extends VeiculoMotorizado{

    private static final Double consumo = 1.5d;
    private static final Integer qtdeMovimento = 10;
    private static final Double capacidadeTanque = 50d;
    
    public Ferrari() {
        super("F", 4);
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
        return "Ferrari: " + super.toString();
    }
    
    
}

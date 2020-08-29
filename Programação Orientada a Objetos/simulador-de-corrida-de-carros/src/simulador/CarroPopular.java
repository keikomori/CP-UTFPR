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
public class CarroPopular extends VeiculoMotorizado{

    private static final Double consumo = 1d;
    private static final Integer qtdeMovimento = 5;
    private static final Double capacidadeTanque = 40d;
    
    public CarroPopular() {
        super("C", 4);
    }

    @Override
    void abastecer(Double litros) {
        if(litros <= capacidadeTanque){//se a quantidade de combustivel passada por parametro for menor igual a capacidade do tanque, significa que nao vai sobrar combustivel
            if(super.getCombustivel() < capacidadeTanque){//verifica se o tanque ja esta cheio
                Double abastecer = super.getCombustivel() + litros;
               if(abastecer <= capacidadeTanque){
                   super.setCombustivel(abastecer);
               }
               else{//Caso a quantidade de litros passada por parametro for maior que a capacidade do tanque, e setado a capacidade maxima do tanque
                   super.setCombustivel(capacidadeTanque);
               }
            }
        }
        else{//Caso a quantidade de litros passada por parametro for maior que a capacidade do tanque, e setado a capacidade maxima do tanque
            super.setCombustivel(capacidadeTanque);
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
        return "CarroPopular{" + '}' + super.toString();
    }
    
    
    
}

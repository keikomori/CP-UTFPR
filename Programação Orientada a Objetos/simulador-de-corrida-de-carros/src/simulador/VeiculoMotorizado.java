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
public abstract class VeiculoMotorizado extends Veiculo {
    
    private Double combustivel;

    public VeiculoMotorizado(String tipo, Integer qtdeRodas) {
        super(tipo, qtdeRodas);
        this.combustivel = 0d;
    }    
    
    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }
    
    abstract void abastecer(Double litros);

    @Override
    public String toString() {
        return super.toString() +  " VeiculoMotorizado{" + "combustivel=" + combustivel + '}';
    }
    
    
}

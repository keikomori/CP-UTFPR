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
public abstract class Veiculo {
    private String tipo;
    private static Integer contadorId = 0;
    private Integer distanciaPercorrida;
    private Roda[] rodas; //este vetor tem que ser inicializado no construtor da classe
    private Integer qtdeRodas = 0;

    public Veiculo(String tipo, Integer qtdeRodas) {
        this.tipo = tipo + contadorId;
        this.distanciaPercorrida = 0;
        this.qtdeRodas = qtdeRodas;
        inicializaRodas();
        contadorId++;
    }
    
    private void inicializaRodas(){
        if(this.qtdeRodas > 0){
            rodas = new Roda[this.qtdeRodas];
            for(int i = 0; i < this.qtdeRodas; i++ ){
                rodas[i] = new Roda(Boolean.TRUE);//seta de inicio que o pneu esta calibrado
            }
        }
    }
    
    /**
     * Este metodo serve para calibrar todos os pneus do veiculo.
     * true para calibrar os pneus
     * false para esvaziar os pneus.
     * @return void
     */
    public void calibrarPneus(Boolean acao){
        for(int i = 0; i < this.qtdeRodas; i++ ){
                rodas[i].setCalibragemPneu(acao);//seta de inicio que o pneu esta calibrado
            }
    }
    
    public Boolean getCalibragem(){
        for(int i = 0; i < this.qtdeRodas; i++ ){
                if(rodas[i].getCalibragemPneu() == false){
                    return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
    
    public String getId(){
        return this.tipo;
    }
    
    abstract void mover();
    
    abstract String imprimirTragetoria();

    public Integer getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(Integer distanciaPercorrida) {
        this.distanciaPercorrida += distanciaPercorrida;
    }
    
    @Override
    public String toString() {
        return "Veiculo{" + "Id = " + tipo + ", distanciaPercorrida=" + distanciaPercorrida + ", rodas= " + qtdeRodas + '}';
    }
    
}

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
public class Roda {
    private Boolean calibragemPneu;

    public Roda(Boolean calibragemPneu) {
        this.calibragemPneu = calibragemPneu;
    }

    public Roda() {
    }

    public Boolean getCalibragemPneu() {
        return calibragemPneu;
    }

    public void setCalibragemPneu(Boolean calibragemPneu) {
        this.calibragemPneu = calibragemPneu;
    }    
}

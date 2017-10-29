/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Lusca
 */
public class PercentualCrescimentoMes {
    String intervaloMeses;
    double crescimentoPorcentagem;

    public PercentualCrescimentoMes(String intervaloMeses, double crescimentoPorcentagem) {
        this.intervaloMeses = intervaloMeses;
        this.crescimentoPorcentagem = crescimentoPorcentagem;
    }

    public String getIntervaloMeses() {
        return intervaloMeses;
    }

    public void setIntervaloMeses(String intervaloMeses) {
        this.intervaloMeses = intervaloMeses;
    }

    public double getCrescimentoPorcentagem() {
        return crescimentoPorcentagem;
    }

    public void setCrescimentoPorcentagem(double crescimentoPorcentagem) {
        this.crescimentoPorcentagem = crescimentoPorcentagem;
    }
    
    
    
}

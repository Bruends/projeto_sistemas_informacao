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
public class PercentualCrescimentoAno {
    String intervaloDeAnos;
    double porcentagemDeCrescimento;

    public PercentualCrescimentoAno(String intervaloDeAnos, double porcentagemDeCrescimento) {
        this.intervaloDeAnos = intervaloDeAnos;
        this.porcentagemDeCrescimento = porcentagemDeCrescimento;
    }

    public PercentualCrescimentoAno() {
    }

    public String getIntervaloDeAnos() {
        return intervaloDeAnos;
    }

    public void setIntervaloDeAnos(String intervaloDeAnos) {
        this.intervaloDeAnos = intervaloDeAnos;
    }

    public double getPorcentagemDeCrescimento() {
        return porcentagemDeCrescimento;
    }

    public void setPorcentagemDeCrescimento(double porcentagemDeCrescimento) {
        this.porcentagemDeCrescimento = porcentagemDeCrescimento;
    }
    
    
    
}

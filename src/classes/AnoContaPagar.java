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
public class AnoContaPagar {
    private String ano;
    private double somaValores;
    

    public AnoContaPagar() {
    }

    public AnoContaPagar(String ano, double somaValores) {
        this.ano = ano;
        this.somaValores = somaValores;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getSomaValores() {
        return somaValores;
    }

    public void setSomaValores(double somaValores) {
        this.somaValores = somaValores;
    }

    
    
    
}

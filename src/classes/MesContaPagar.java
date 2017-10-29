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
public class MesContaPagar {
    private String nome;
    private ContaPagar contaPagar;

    public MesContaPagar(String nome, ContaPagar contaPagar) {
        this.nome = nome;
        this.contaPagar = contaPagar;
    }

    public MesContaPagar() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
    }
    
    
    
}

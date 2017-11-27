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
public class MesContaReceber {
    private String nome;
    private ContaReceber contaReceber;

    public MesContaReceber(String nome, ContaReceber contaReceber) {
        this.nome = nome;
        this.contaReceber = contaReceber;
    }

    public MesContaReceber() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaReceber getContaReceber() {
        return this.contaReceber;
    }

    public void setContaReceber(ContaReceber contaReceber) {
        this.contaReceber = contaReceber;
    }
    
    
    
}

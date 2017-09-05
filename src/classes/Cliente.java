/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author bruno
 */
public class Cliente {
    private int cod;
   
    private String nome;
    private String email;
    private String endereco;
    private String cnpj;
    
    public Cliente(){ }
    
    public Cliente(int cod,String n, String e, String en, String c){
        this.cod = cod;
        this.nome = n;
        this.email = e;
        this.endereco = en;
        this.cnpj = c;        
    }
    
     public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }  
    
}

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
    private String telefone;
    private String cep;
    private String nome;
    private String email;
    private String endereco;
    private String cnpj;
    
    public Cliente(){ }

    public Cliente(String telefone, String cep, String nome, String email, String endereco, String cnpj) {        
        this.telefone = telefone;
        this.cep = cep;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public Cliente(int cod, String telefone, String cep, String nome, String email, String endereco, String cnpj) {
        this.cod = cod;
        this.telefone = telefone;
        this.cep = cep;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    public Cliente(int cod) {
        this.cod = cod;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}

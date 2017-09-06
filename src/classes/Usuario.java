package classes;


public class Usuario {
    private String email;
    private String senha;
    private int nivel_acesso;
    private String nome;
    private int ano_nascimento;
    
    
    public Usuario(String e, String s, int na){
        this.email = e;
        this.senha = s;
        this.nivel_acesso = na;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public boolean setAno_nascimento(int ano_nascimento) {
        if(ano_nascimento > 2017 && ano_nascimento < 1800) {
            this.ano_nascimento = ano_nascimento;
            return true;
            
        } else {
            return false;
            
        }
        
    }
    
      
    
}

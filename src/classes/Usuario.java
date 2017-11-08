package classes;

public class Usuario {    
    private int cod;
    private String email;
    private String senha;
    private int nivel_acesso;
    private String nome;
    private String cpf;    
    private int ano_nascimento;    
    private String cargo;    
    private String departamento;    
    private float salario;    
    private String telefone;
    private String endereco;
    private String email_Acesso;
    
    
    public Usuario(String e, String s, int na){
        this.email = e;
        this.senha = s;
        this.nivel_acesso = na;
    }

    public Usuario(String email, String senha, int nivel_acesso, String nome) {
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.nome = nome;
    }

   

    
    public Usuario( String email, String senha, int nivel_acesso, String nome, String cpf, int ano_nascimento, String cargo, String departamento, float salario, String telefone, String endereco,String emailAcesso, int cod) {        
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.nome = nome;
        this.cpf = cpf;
        this.ano_nascimento = ano_nascimento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email_Acesso = emailAcesso;
        this.cod = cod;
    }

     public Usuario( String email,  int nivel_acesso, String nome, String cpf, int ano_nascimento, String cargo, String departamento, float salario, String telefone, String endereco, int cod) {        
        this.email = email;        
        this.nivel_acesso = nivel_acesso;
        this.nome = nome;
        this.cpf = cpf;
        this.ano_nascimento = ano_nascimento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;        
        this.cod = cod;
    }
    public Usuario( String email, String senha, int nivel_acesso, String nome, String cpf, int ano_nascimento, String cargo, String departamento, float salario, String telefone, String endereco,String emailAcesso) {        
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.nome = nome;
        this.cpf = cpf;
        this.ano_nascimento = ano_nascimento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email_Acesso = emailAcesso;        
    }
    
    public Usuario() {        
    }
    
    //getter e setters

    public String getEmail_Acesso() {
        return email_Acesso;
    }

    public void setEmail_Acesso(String email_Acesso) {
        this.email_Acesso = email_Acesso;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public void setAno_nascimento(int ano_nascimento) {        
            this.ano_nascimento = ano_nascimento;
    }
        
    
    
      
    
}

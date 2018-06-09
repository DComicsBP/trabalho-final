package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.Usuario;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.CadastroGeral.Contato;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.CadastroGeral.Endereco;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
    
    @Id
    private int id;
    @NotNull
    private String nome; 
    @NotNull
    private String login; 
    @NotNull
    private String senha; 
    @NotNull
    private String tipo;
   
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
}

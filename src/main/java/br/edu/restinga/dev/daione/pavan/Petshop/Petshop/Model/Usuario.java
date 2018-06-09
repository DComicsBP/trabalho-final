package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Contato;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Endereco;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @NotNull
    private String nome; 
    @NotNull
    private String login; 
    @NotNull
    private String senha; 
    @NotNull
    private String tipo;
   
    
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

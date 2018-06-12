package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "usuarios")
@Inheritance (strategy = InheritanceType.JOINED)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "tipo" )
@JsonSubTypes({
    @JsonSubTypes.Type(name = "cliente", value = Cliente.class),
    @JsonSubTypes.Type(name = "veterinario", value = Veterinario.class),
    @JsonSubTypes.Type(name = "funcionario", value = Funcionario.class),

})

public abstract class Usuario implements Serializable {
    
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
    @NotNull
    private int endereco; 
    @NotNull
    private int contato; 
    
    @Transient
    @JsonProperty
    private final String tipoUsuario = "tipo";
    
    
    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }
   
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

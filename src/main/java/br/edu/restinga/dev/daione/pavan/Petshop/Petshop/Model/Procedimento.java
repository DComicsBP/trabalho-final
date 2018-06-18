package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
    @ElementCollection
    private List<String> tipoProcedimento; 
    private String observacoes; 
    private int IdPet;
    private int IDFuncionario; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<String> getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(List<String> tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getIdPet() {
        return IdPet;
    }

    public void setIdPet(int IdPet) {
        this.IdPet = IdPet;
    }

    public int getIDFuncionario() {
        return IDFuncionario;
    }

    public void setIDFuncionario(int IDFuncionario) {
        this.IDFuncionario = IDFuncionario;
    }
}

package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoProcedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
    private String TipoProcedimento; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipoProcedimento() {
        return TipoProcedimento;
    }

    public void setTipoProcedimento(String TipoProcedimento) {
        this.TipoProcedimento = TipoProcedimento;
    }
    
}

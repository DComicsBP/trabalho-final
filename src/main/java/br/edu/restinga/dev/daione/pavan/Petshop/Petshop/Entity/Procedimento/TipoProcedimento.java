package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.Procedimento;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoProcedimento {
    @Id
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

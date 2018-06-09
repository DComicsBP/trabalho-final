package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.PetCliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PetCliente {
    @Id
    private int ID; 
    @NotNull
    private int IDPet;
    @NotNull
    private int IDCliente; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPet() {
        return IDPet;
    }

    public void setIDPet(int IDPet) {
        this.IDPet = IDPet;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }
    
    
    
    
    
}

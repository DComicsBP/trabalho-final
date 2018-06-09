
package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.Usuario;

import javax.persistence.Entity;

@Entity
public class Veterinario extends Funcionario  {
    String CRMV; 

    public String getCRMV() {
        return CRMV;
    }

    public void setCRMV(String CRMV) {
        this.CRMV = CRMV;
    }
    
    
}

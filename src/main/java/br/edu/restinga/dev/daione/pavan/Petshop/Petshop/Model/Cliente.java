
package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;

@Entity

public class Cliente extends Usuario{
    @JsonProperty("tipo")
    private final String tipoUsuario = "cliente";
    
    
    
}

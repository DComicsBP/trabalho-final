
package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Funcionario extends Usuario {
     @JsonProperty("tipo")
    private final String tipoUsuario = "funcionario";
    
    
}

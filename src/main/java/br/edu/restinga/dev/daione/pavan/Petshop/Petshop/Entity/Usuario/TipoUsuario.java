package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Entity.Usuario;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoUsuario {
    @Id
    private int ID; 
    private String TipoUsuario; 
  }

package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 10070269
 */
@Repository
public interface ContatoDAO extends CrudRepository <Contato, Integer>{
}
package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.PetDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    PetDAO dao;

    @RequestMapping(path = "/pet", method = RequestMethod.GET)
    public Iterable<Pet> listar() {
        return dao.findAll();
    }
    
}

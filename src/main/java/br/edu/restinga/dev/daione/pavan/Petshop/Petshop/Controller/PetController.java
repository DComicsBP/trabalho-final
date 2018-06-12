package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.PetDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Pet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    PetDAO petDao;

    @RequestMapping(path = "/pet", method = RequestMethod.GET)
    public Iterable<Pet> listar() {
        return petDao.findAll();
    }

   

}


/*
 @RequestMapping(path = "/pet/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Pet salvar(@RequestBody Pet pet) {
        pet.setID(0);
        return petDao.save(pet);
    }

    @RequestMapping(path = "/pet/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Pet pet) {
          if (!petDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        pet.setID(id);
        petDao.save(pet);
    }

    @RequestMapping(path = "/PET/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pet> recuperar(@PathVariable int id) {
        Optional<Pet> findById = petDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/pet/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!petDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        petDao.deleteById(id);
    }
*/
package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.PetClienteDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.PetCliente;
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
public class PetClienteController {

    @Autowired
    PetClienteDAO petCLienteDao;

    @RequestMapping(path = "/pet-cliente", method = RequestMethod.GET)
    public Iterable<PetCliente> listar() {
        return petCLienteDao.findAll();
    }

 @RequestMapping(path = "/pet-cliente/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public PetCliente salvar(@RequestBody PetCliente petCLiente) {
        petCLiente.setID(0);
        return petCLienteDao.save(petCLiente);
    }

    @RequestMapping(path = "/pet-cliente/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody PetCliente petCLiente) {
          if (!petCLienteDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        petCLiente.setID(id);
        petCLienteDao.save(petCLiente);
    }

    @RequestMapping(path = "/pet-cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<PetCliente> recuperar(@PathVariable int id) {
        Optional<PetCliente> findById = petCLienteDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/pet-cliente/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!petCLienteDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        petCLienteDao.deleteById(id);
    }
}

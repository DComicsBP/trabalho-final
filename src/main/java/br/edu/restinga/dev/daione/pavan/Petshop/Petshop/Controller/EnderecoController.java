package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.EnderecoDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Endereco;
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
public class EnderecoController {

    @Autowired
    EnderecoDAO enderecoDao;

    @RequestMapping(path = "/endereco", method = RequestMethod.GET)
    public Iterable<Endereco> listar() {
        return enderecoDao.findAll();
    }

 @RequestMapping(path = "/endereco/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco) {
        endereco.setId(0);
        return enderecoDao.save(endereco);
    }

    @RequestMapping(path = "/endereco/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Endereco endereco) {
          if (!enderecoDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        endereco.setId(id);
        enderecoDao.save(endereco);
    }

    @RequestMapping(path = "/endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> recuperar(@PathVariable int id) {
        Optional<Endereco> findById = enderecoDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/endereco/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!enderecoDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        enderecoDao.deleteById(id);
    }
}

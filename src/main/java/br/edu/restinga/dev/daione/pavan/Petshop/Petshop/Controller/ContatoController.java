package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.ContatoDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Contato;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Endereco;
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
public class ContatoController {

    @Autowired
    ContatoDAO contatoDao;

    @RequestMapping(path = "/contato", method = RequestMethod.GET)
    public Iterable<Contato> listar() {
        return contatoDao.findAll();
    }

 @RequestMapping(path = "/contato/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody Contato contato) {
        contato.setID(0);
        return contatoDao.save(contato);
    }

    @RequestMapping(path = "/contato/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Contato contato) {
          if (!contatoDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        contato.setID(id);
        contatoDao.save(contato);
    }

    @RequestMapping(path = "/contato/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contato> recuperar(@PathVariable int id) {
        Optional<Contato> findById = contatoDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/contato/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!contatoDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        contatoDao.deleteById(id);
    }
}

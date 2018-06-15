package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.ProcedimentoDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Pet;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Procedimento;
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
public class ProcedimentoController {

    @Autowired
    ProcedimentoDAO procedimentoDAO;

    @RequestMapping(path = "/procedimento", method = RequestMethod.GET)
    public Iterable<Procedimento> listar() {
        return procedimentoDAO.findAll();
    }

 @RequestMapping(path = "/procedimento/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Procedimento salvar(@RequestBody Procedimento procedimento) {
        procedimento.setID(0);
        return procedimentoDAO.save(procedimento);
    }

    @RequestMapping(path = "/procedimento/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Procedimento procedimento) {
          if (!procedimentoDAO.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        procedimento.setID(id);
        procedimentoDAO.save(procedimento);
    }

    @RequestMapping(path = "/procedimento/{id}", method = RequestMethod.GET)
    public ResponseEntity<Procedimento> recuperar(@PathVariable int id) {
        Optional<Procedimento> findById = procedimentoDAO.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/procedimento/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!procedimentoDAO.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        procedimentoDAO.deleteById(id);
    }
}

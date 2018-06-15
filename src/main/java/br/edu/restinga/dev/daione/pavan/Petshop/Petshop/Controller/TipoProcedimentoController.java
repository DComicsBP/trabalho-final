package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.ContatoDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.TipoProcedimentoDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Contato;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Endereco;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.TipoProcedimento;
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
public class TipoProcedimentoController {

    @Autowired
    TipoProcedimentoDAO tipoProcedimentoDAO;

    @RequestMapping(path = "/tipo-procedimento", method = RequestMethod.GET)
    public Iterable<TipoProcedimento> listar() {
        return tipoProcedimentoDAO.findAll();
    }

 @RequestMapping(path = "/tipo-procedimento/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProcedimento salvar(@RequestBody TipoProcedimento tipoProcedimento) {
        tipoProcedimento.setID(0);
        return tipoProcedimentoDAO.save(tipoProcedimento);
    }

    @RequestMapping(path = "/tipo-procedimento/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody TipoProcedimento tipoProcedimento) {
          if (!tipoProcedimentoDAO.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        tipoProcedimento.setID(id);
        tipoProcedimentoDAO.save(tipoProcedimento);
    }

    @RequestMapping(path = "/tipo-procedimento/{id}", method = RequestMethod.GET)
    public ResponseEntity<TipoProcedimento> recuperar(@PathVariable int id) {
        Optional<TipoProcedimento> findById = tipoProcedimentoDAO.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/tipo-procedimento/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!tipoProcedimentoDAO.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        tipoProcedimentoDAO.deleteById(id);
    }
}

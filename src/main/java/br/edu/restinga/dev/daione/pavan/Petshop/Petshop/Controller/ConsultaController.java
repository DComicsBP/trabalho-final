package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.ConsultaDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Consulta;
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
public class ConsultaController {

    @Autowired
    ConsultaDAO consultaDao;

    @RequestMapping(path = "/consulta", method = RequestMethod.GET)
    public Iterable<Consulta> listar() {
        return consultaDao.findAll();
    }

 @RequestMapping(path = "/consulta/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta salvar(@RequestBody Consulta consulta) {
        consulta.setID(0);
        return consultaDao.save(consulta);
    }

    @RequestMapping(path = "/consulta/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Consulta consulta) {
          if (!consultaDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        consulta.setID(id);
        consultaDao.save(consulta);
    }

    @RequestMapping(path = "/consulta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Consulta> recuperar(@PathVariable int id) {
        Optional<Consulta> findById = consultaDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/consulta/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!consultaDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        consultaDao.deleteById(id);
    }
}
    
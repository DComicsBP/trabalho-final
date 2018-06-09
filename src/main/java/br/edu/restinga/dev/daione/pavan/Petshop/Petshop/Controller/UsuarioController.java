package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Controller;

import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO.UsuarioDAO;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Errors.NaoEncontrado;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Usuario;
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
public class UsuarioController {

    @Autowired
    UsuarioDAO usuarioDao;

    @RequestMapping(path = "/pet", method = RequestMethod.GET)
    public Iterable<Usuario> listar() {
        return usuarioDao.findAll();
    }

    @RequestMapping(path = "/usuario/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario) {
        usuario.setID(0);
        return usuarioDao.save(usuario);
    }

    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody Usuario usuario) {
          if (!usuarioDao.existsById(id)) {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
        }
        usuario.setID(id);
        usuarioDao.save(usuario);
    }

    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> recuperar(@PathVariable int id) {
        Optional<Usuario> findById = usuarioDao.findById(id);
        if (findById.isPresent()) {
            return ResponseEntity.ok(findById.get());
        } else {
            throw new NaoEncontrado("Produto de id: " + id + " não encontrado");
//            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id) {
        if (!usuarioDao.existsById(id)) {
            throw new NaoEncontrado("Usuario de id: " + id + " não encontrado");
        }
        usuarioDao.deleteById(id);
    }

}

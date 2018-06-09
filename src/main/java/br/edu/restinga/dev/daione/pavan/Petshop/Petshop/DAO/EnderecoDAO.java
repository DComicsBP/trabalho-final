package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO;


import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoDAO extends CrudRepository <Endereco, Integer>{
}
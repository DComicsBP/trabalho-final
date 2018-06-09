package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO;




import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Consulta;
import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsultaDAO extends CrudRepository <Consulta, Integer>{
}
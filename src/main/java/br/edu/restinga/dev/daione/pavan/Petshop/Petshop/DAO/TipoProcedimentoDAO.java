package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO;




import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.TipoProcedimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProcedimentoDAO extends CrudRepository <TipoProcedimento, Integer>{
}


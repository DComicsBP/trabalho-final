package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.DAO;



import br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDAO extends CrudRepository <Pet, Integer>{
    
}

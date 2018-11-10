package br.com.unipar.EstagioSerch.demo.repository;

import br.com.unipar.EstagioSerch.demo.models.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Long> {

    
}

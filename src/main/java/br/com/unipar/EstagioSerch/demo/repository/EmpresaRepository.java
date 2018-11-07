package br.com.unipar.EstagioSerch.demo.repository;

import br.com.unipar.EstagioSerch.demo.models.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}

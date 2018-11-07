package br.com.unipar.EstagioSerch.demo.repository;

import br.com.unipar.EstagioSerch.demo.models.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {
}

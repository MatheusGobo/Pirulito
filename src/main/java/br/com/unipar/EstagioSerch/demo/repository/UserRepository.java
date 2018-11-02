package br.com.unipar.EstagioSerch.demo.repository;

import br.com.unipar.EstagioSerch.demo.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository  extends PagingAndSortingRepository(User, Long) {

    //User findByUsername(String login);

}

package br.com.unipar.EstagioSerch.demo.service;

import br.com.unipar.EstagioSerch.demo.models.User;
import br.com.unipar.EstagioSerch.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityListAluno = AuthorityUtils.createAuthorityList("ALUNO");
        List<GrantedAuthority> authorityListEmpresa = AuthorityUtils.createAuthorityList("EMPRESA");
        List<GrantedAuthority> authorityListUniversidade = AuthorityUtils.createAuthorityList("UNIVERSIDADE");

        System.out.println(user.getUsername() + user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityListAluno);
    }
}

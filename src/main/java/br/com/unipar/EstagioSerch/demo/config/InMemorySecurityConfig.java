package br.com.unipar.EstagioSerch.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("ALUNO")
                .and()
                .withUser("irineu").password("{noop}password").roles("EMPRESA");

    }
}

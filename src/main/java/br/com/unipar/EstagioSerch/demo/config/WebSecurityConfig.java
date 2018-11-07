package br.com.unipar.EstagioSerch.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

      protected void configure(HttpSecurity http) throws Exception{
          http.authorizeRequests()
                  .antMatchers("/vagas/cadastro").hasAnyRole("EMPRESA")
                  .anyRequest()
                  .authenticated()
                  .and()
                  .formLogin()
                        .loginPage("/login").successForwardUrl("/")
                        .permitAll()

                  .and()
                  .logout().logoutSuccessUrl("/login").permitAll();
      }


}

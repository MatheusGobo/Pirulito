package br.com.unipar.EstagioSerch.demo.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    private String password(String senha){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("newsecurity"));
        return passwordEncoder.encode(senha);
    };
}

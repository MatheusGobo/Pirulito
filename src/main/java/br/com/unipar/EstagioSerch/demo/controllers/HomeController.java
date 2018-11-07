
package br.com.unipar.EstagioSerch.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @PreAuthorize("hasRole('ALUNO')")
    @RequestMapping("/")
    public String home(Model model,boolean status) {
        /*    if(status == true) {
            return "index";
        }else{
            return "login";
        }*/
        return "index";
    }



    
}



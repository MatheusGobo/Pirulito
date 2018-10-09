
package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.models.Vaga;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    public String teste;
    public Vaga vaga;
    
    public ArrayList vagas = new ArrayList();
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("teste", "bIHOU");
        return "index";
    }
    
}



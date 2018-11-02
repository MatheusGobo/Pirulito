
package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.DAO.VagaDAO;
import br.com.unipar.EstagioSerch.demo.models.Vaga;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    

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



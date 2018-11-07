
package br.com.unipar.EstagioSerch.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login(Model model,boolean status) {
        return "login";
    }


    @RequestMapping("/")
    public String home(Model model,boolean status) {
        model.addAttribute("page", "index");
        return "main";
    }




    
}



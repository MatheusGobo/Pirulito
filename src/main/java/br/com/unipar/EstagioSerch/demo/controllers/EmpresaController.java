package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.DAO.EmpresaDAO;
import br.com.unipar.EstagioSerch.demo.models.Empresa;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaDAO empresadao;
    
    @GetMapping
    public String list(Model model){
    model.addAttribute("empresas", empresadao.lista());
    model.addAttribute("page", "empresa/lista");
    return "main";
        
    }
      @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleta(@PathVariable("codigo") Long codigo) {
        empresadao.deletar(codigo);
    }
    
     @GetMapping({"/cadastro", "/cadastro/{codigo}"})
    public String cadastro(@PathVariable("codigo") Optional<Long> codigo, Model model) {
        if (codigo.isPresent()) {
            model.addAttribute("empresa", empresadao.busca(codigo.get()));
        } else {
            model.addAttribute("empresa", new Empresa());
        }
        model.addAttribute("page", "empresa/cadastro");
        return "main";
    }
    
    @PostMapping({"/cadastro", "/cadastro/{codigo}"})
    public String grava(@PathVariable("codigo") Optional<Long> codigo, Empresa empresa) {
        if (codigo.isPresent()) {
            empresadao.atualizar(codigo.get(), empresa);
        } else {
            empresadao.salvar(empresa);
        }
        return "redirect:/index";
    }
}

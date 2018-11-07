package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.models.Empresa;
import br.com.unipar.EstagioSerch.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public String Perfil(Model model, Long cod) {
        model.addAttribute("empresa", empresaRepository.findById(cod));
        model.addAttribute("page", "empresa");
        return "main";

    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleta(@PathVariable("codigo") Long codigo) {
        empresaRepository.deleteById(codigo);
    }

    @GetMapping({"/cadastro", "/cadastro/{codigo}"})
    public String cadastro(@PathVariable("codigo") Optional<Long> codigo, Model model) {
        if (codigo.isPresent()) {
            model.addAttribute("empresa", empresaRepository.findById(codigo.get()).get());
        } else {
            model.addAttribute("empresa", new Empresa());
        }
        model.addAttribute("page", "cadastroEmpresa");
        return "main";
    }

    @PostMapping({"/cadastro", "/cadastro/{codigo}"})
    public String grava(@PathVariable("codigo") Optional<Long> codigo, Empresa empresa) {
        empresaRepository.save(empresa);
        return "redirect:/index";
    }
}

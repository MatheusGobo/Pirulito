
package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.DAO.AreaDAO;
import br.com.unipar.EstagioSerch.demo.DAO.VagaDAO;
import br.com.unipar.EstagioSerch.demo.models.Vaga;

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
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaDAO vagadao;
    private AreaDAO areadao;

    public VagaController(AreaDAO areadao) {
        this.areadao = areadao;
    }


    @GetMapping
    public String list(Model model) {
        model.addAttribute("vagas", vagadao.lista());
        model.addAttribute("page", "listaVaga");
        return "main";
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleta(@PathVariable("codigo") Long codigo) {
        vagadao.deletar(codigo);
    }

    @GetMapping({"/cadastro", "/cadastro/{codigo}"})
    public String cadastro(@PathVariable("codigo") Optional<Long> codigo, Model model) {

        if (codigo.isPresent()) {
            model.addAttribute("vaga", vagadao.busca(codigo.get()));
        } else {
            model.addAttribute("vaga", new Vaga());
        }
        model.addAttribute("areas", areadao.lista());
        model.addAttribute("page", "cadastroVagas");
        return "main";
    }

    @PostMapping({"/cadastro", "/cadastro/{codigo}"})
    public String grava(@PathVariable("codigo") Optional<Long> codigo, Vaga vaga) {
        if (codigo.isPresent()) {
            vagadao.atualizar(codigo.get(), vaga);
        } else {
            vagadao.salvar(vaga);
        }
        return "redirect:/index";
    }

}

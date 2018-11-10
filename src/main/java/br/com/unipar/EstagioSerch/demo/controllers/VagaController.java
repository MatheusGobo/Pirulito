
package br.com.unipar.EstagioSerch.demo.controllers;

import br.com.unipar.EstagioSerch.demo.repository.AreaRepository;
import br.com.unipar.EstagioSerch.demo.repository.EmpresaRepository;
import br.com.unipar.EstagioSerch.demo.repository.VagaRepository;
import br.com.unipar.EstagioSerch.demo.models.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.DataInput;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;
    private AreaRepository areaRepository;
    private EmpresaRepository empresaRepository;



    public VagaController(AreaRepository areaRepository , EmpresaRepository empresaRepository) {
        this.areaRepository = areaRepository;
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("vagas", vagaRepository.findAll());
        model.addAttribute("page", "listaVaga");

        return "main";
    }


    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleta(@PathVariable("codigo") Long codigo) {
        vagaRepository.deleteById(codigo);
    }

    @GetMapping({"/cadastro", "/cadastro/{codigo}"})
    public String cadastro(@PathVariable("codigo") Optional<Long> codigo, Model model) {

        if (codigo.isPresent()) {
            model.addAttribute("vaga", vagaRepository.findById(codigo.get()).get());
        } else {
            model.addAttribute("vaga", new Vaga());
        }

        model.addAttribute("areas", areaRepository.findAll());
        model.addAttribute("empresas" , empresaRepository.findAll());
        model.addAttribute("page", "cadastroVagas");
        return "main";
    }

    @PostMapping({"/cadastro", "/cadastro/{codigo}"})
    public String grava(@PathVariable("codigo") Optional<Long> codigo, Vaga vaga) {
         Date date = new Date();
        vaga.setDt_registro(date);
        vagaRepository.save(vaga);
        return "redirect:/";
    }

}

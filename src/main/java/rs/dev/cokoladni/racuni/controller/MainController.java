package rs.dev.cokoladni.racuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.dev.cokoladni.racuni.data.Proizvod;
import rs.dev.cokoladni.racuni.service.ProizvodService;
import rs.dev.cokoladni.racuni.service.RacunService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private RacunService racuniService;

    @Autowired
    public MainController(RacunService racuniService) {
        this.racuniService = racuniService;
    }

    @GetMapping
    private String index(Model model) {
        model.addAttribute("racuni", racuniService.findAll());

        return "index";
    }


}

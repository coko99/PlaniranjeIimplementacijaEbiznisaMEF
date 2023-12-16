package rs.dev.cokoladni.racuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.dev.cokoladni.racuni.data.Proizvod;
import rs.dev.cokoladni.racuni.service.ProizvodService;

import java.util.List;

@Controller
@RequestMapping("/proizvodi")
public class ProizvodiController {
    private ProizvodService proizvodService;

    @Autowired
    public ProizvodiController(ProizvodService proizvodService) {
        this.proizvodService = proizvodService;
    }

    @GetMapping
    public String getProizvodi(Model model) {
        List<Proizvod> proizvodiList = proizvodService.findAll();
        model.addAttribute("proizvodi", proizvodiList);
        model.addAttribute("proizvod", new Proizvod());
        return "proizvodi";
    }

    @PostMapping("create-proizvod")
    public String createProizvod(@ModelAttribute Proizvod proizvod) {
        proizvodService.saveProizvod(proizvod);
        return "redirect:/proizvodi";
    }
}

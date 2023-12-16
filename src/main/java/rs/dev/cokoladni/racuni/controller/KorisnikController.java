package rs.dev.cokoladni.racuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.dev.cokoladni.racuni.data.Korisnik;
import rs.dev.cokoladni.racuni.data.Proizvod;
import rs.dev.cokoladni.racuni.service.KorisnikService;

import java.util.List;

@Controller
@RequestMapping("/korisnik")
public class KorisnikController {

    private KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getProizvodi(Model model) {
        List<Korisnik> korisnikList = korisnikService.findAll();
        model.addAttribute("korisnici", korisnikList);
        model.addAttribute("korisnik", new Korisnik());
        return "korisnik";
    }

//    // Mapping to display the form
//    @GetMapping("/edit")
//    public String showCreateKorisnikForm(Model model) {
//        model.addAttribute("korisnik", new Korisnik());
//        return "fragment/createKorisnikModal :: createKorisnikModal"; // Assuming you have a Thymeleaf template named "createKorisnik.html"
//    }

    // Mapping to handle the form submission
    @PostMapping("/create")
    public String createKorisnik(@ModelAttribute Korisnik korisnik) {
        // You can add validation logic here if needed

        // Call the service to save the Korisnik
        korisnikService.saveKorisnik(korisnik);

        // Redirect to the Korisnici list page or any other page as needed
        return "redirect:/korisnik";
    }
}

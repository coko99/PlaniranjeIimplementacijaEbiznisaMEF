package rs.dev.cokoladni.racuni.controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rs.dev.cokoladni.racuni.data.Racun;
import rs.dev.cokoladni.racuni.service.KorisnikService;
import rs.dev.cokoladni.racuni.service.PdfService;
import rs.dev.cokoladni.racuni.service.ProizvodService;
import rs.dev.cokoladni.racuni.service.RacunService;

@Controller
@RequestMapping("/racuni")
public class RacuniController {

    private ProizvodService proizvodService;
    private KorisnikService korisnikService;
    private RacunService racunService;
    private PdfService pdfService;

    @Autowired
    public RacuniController(ProizvodService proizvodService, KorisnikService korisnikService, RacunService racunService,
                            PdfService pdfService) {
        this.proizvodService = proizvodService;
        this.korisnikService = korisnikService;
        this.racunService = racunService;
        this.pdfService = pdfService;
    }

    @GetMapping
    public String showCreateRacunForm(Model model) {
        model.addAttribute("proizvodi", proizvodService.findAll());
        model.addAttribute("korisnici", korisnikService.findAll());
        model.addAttribute("racun", new Racun());
        return "creatRacun";
    }

    @PostMapping("/create-racun")
    public String createRacun(@ModelAttribute Racun racun) {
        racunService.save(racun);
        return "redirect:/";
    }

    @PostMapping("/print-pdf")
    public ResponseEntity<byte[]> printPdf(@RequestParam("racunId") Integer racunId) throws DocumentException {
        // Retrieve Racun object from the database (replace this with your own logic)
        Racun racun = racunService.findById(racunId).orElse(null);

        if (racun == null) {
            // Handle case where Racun is not found
            return ResponseEntity.notFound().build();
        }

        // Generate PDF bytes
        byte[] pdfBytes = pdfService.generateInvoicePdf(racun);

        // Set up HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "invoice.pdf");

        return new ResponseEntity<>(pdfBytes, headers,  HttpStatus.OK);
    }


}

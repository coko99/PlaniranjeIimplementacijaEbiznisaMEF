package rs.dev.cokoladni.racuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.dev.cokoladni.racuni.data.Korisnik;
import rs.dev.cokoladni.racuni.repository.KorisnikRepository;
import rs.dev.cokoladni.racuni.repository.ProizvodRepository;

import java.util.List;

@Service
public class KorisnikService {

    private KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }


    public Korisnik saveKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }
}

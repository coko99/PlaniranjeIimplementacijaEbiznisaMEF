package rs.dev.cokoladni.racuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.dev.cokoladni.racuni.data.Racun;
import rs.dev.cokoladni.racuni.repository.KorisnikRepository;
import rs.dev.cokoladni.racuni.repository.RacunRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RacunService {

    private RacunRepository racunRepository;

    @Autowired
    public RacunService(RacunRepository racunRepository) {
        this.racunRepository = racunRepository;
    }

    public List<Racun> findAll() {
        return racunRepository.findAll();
    }

    public Racun save(Racun racun) {
        racun.setDatetime(new Date());
        racun.setBrojRacuna(UUID.randomUUID().toString());
        return racunRepository.save(racun);
    }

    public Optional<Racun> findById(Integer racunId) {
        return racunRepository.findById(racunId);
    }
}

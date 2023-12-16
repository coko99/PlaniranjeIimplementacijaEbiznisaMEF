package rs.dev.cokoladni.racuni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.dev.cokoladni.racuni.data.Proizvod;
import rs.dev.cokoladni.racuni.repository.ProizvodRepository;

import java.util.List;

@Service
public class ProizvodService {

    private ProizvodRepository proizvodRepository;

    @Autowired
    public ProizvodService(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    public List<Proizvod> findAll() {
        return proizvodRepository.findAll();
    }

    public Proizvod saveProizvod(Proizvod proizvod) {
        // Your business logic (e.g., validation) can go here

        // Save the Proizvod to the database
        return proizvodRepository.save(proizvod);
    }
}

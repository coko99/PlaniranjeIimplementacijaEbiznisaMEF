package rs.dev.cokoladni.racuni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.dev.cokoladni.racuni.data.Korisnik;
import rs.dev.cokoladni.racuni.data.Proizvod;

import java.util.List;

@Repository
public interface ProizvodRepository extends CrudRepository<Proizvod, Integer> {

    List<Proizvod> findAll();
}

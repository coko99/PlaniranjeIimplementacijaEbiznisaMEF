package rs.dev.cokoladni.racuni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.dev.cokoladni.racuni.data.Korisnik;
import rs.dev.cokoladni.racuni.data.Racun;

import java.util.List;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {

    List<Korisnik> findAll();
}

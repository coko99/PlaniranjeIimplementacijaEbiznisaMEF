package rs.dev.cokoladni.racuni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.dev.cokoladni.racuni.data.Racun;

import java.util.List;

@Repository
public interface RacunRepository extends CrudRepository<Racun, Integer> {

    List<Racun> findAll();
}

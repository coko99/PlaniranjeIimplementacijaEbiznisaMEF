package rs.dev.cokoladni.racuni.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Racun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date datetime;
    private String brojRacuna;

    @ManyToMany
    @JoinTable(
            name = "racun_proizvod",
            joinColumns = @JoinColumn(name = "racun_id"),
            inverseJoinColumns = @JoinColumn(name = "proizvod_id")
    )
    private List<Proizvod> proizvodi;

    @ManyToOne()
    private Korisnik korisnik;


}

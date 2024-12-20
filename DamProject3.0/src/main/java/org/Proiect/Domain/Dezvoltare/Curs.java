package org.Proiect.Domain.Dezvoltare;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.Proiect.Domain.Angajati.Utilizator;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @NotBlank(message = "Titlul cursului este obligatoriu.")
    @Size(max = 100, message = "Titlul cursului nu poate depăși 100 de caractere.")
    private String titlu;
    @OneToMany(mappedBy = "curs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UtilizatorCurs> utilizatoriCursuri;
    @OneToMany(mappedBy = "curs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Badge> badges;
    private String descriere;
    private int durataOre;
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Utilizator admin;
}

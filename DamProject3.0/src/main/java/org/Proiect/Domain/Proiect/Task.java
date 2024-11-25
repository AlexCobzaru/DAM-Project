package org.Proiect.Domain.Proiect;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.Proiect.Domain.Angajati.Utilizator;
import org.Proiect.Domain.App.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int taskUserId;
    @NotBlank(message = "Denumirea task-ului este obligatorie.")
    @Size(max = 100, message = "Denumirea task-ului nu poate depăși 100 de caractere.")
    private String denumire;
    @Size(max = 255, message = "Descrierea nu poate depăși 255 de caractere.")
    private String descriere;
    @NotNull(message = "Data de început este obligatorie.")
    private Date dataIncepere;
    @NotNull(message = "Data de finalizare este obligatorie.")
    private Date dataFinalizare;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Statusul este obligatoriu.")
    private Status status;
    @NotNull(message = "Deadline-ul este obligatoriu.")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "id_proiect")
    private Proiect proiect;

    @ManyToOne
    @JoinColumn(name = "id_lider")
    private Utilizator lider;

    @ManyToOne
    @JoinColumn(name = "membru_id")
    private Utilizator membru;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Notificare> notificari;
}

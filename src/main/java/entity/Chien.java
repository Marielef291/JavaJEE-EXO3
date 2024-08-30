package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chien")
public class Chien {
    @Id
    @GeneratedValue
    @Column(name = "id_Chien")
    protected int id;
    private String nom;
    private String race;
    private String favRepas;
    private LocalDate dateOfBirth;
}

package com.exemplu.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Getter
@Entity
@Table(name="masini")
public class Masina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="Numar_inmatriculare")
    private String Numar_inmatriculare;

    @Column(name="Marca")
    private String Marca;

    @Column(name="Model")
    private String Model;

    @Column(name="Culoare")
    private String Culoare;

    @Column(name="An_fabricatie")
    private int An_fabricatie;

    @Column(name="Capacitate_ciindrica")
    private int Capacitate_ciindrica;

    @Column(name="Combustibil")
    private String Combustibil;

    @Column(name="Putere")
    private int Putere;

    @Column(name="Cuplu")
    private int Cuplu;

    @Column(name="Volum_portbagaj")
    private int Volum_portbagaj;

    @Column(name="Pret")
    private int Pret;

}

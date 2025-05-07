package com.exemplu.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Getter
@Entity
@Table(name="masini")
public class Masina {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name="Numar_inmatriculare")
    public String numarInmatriculare;

    @Column(name="Marca")
    public String marca;

    @Column(name="Model")
    public String model;

    @Column(name="Culoare")
    public String culoare;

    @Column(name="An_fabricatie")
    public int anFabricatie;

    @Column(name="Capacitate_ciindrica")
    public int capacitateCiindrica;

    @Column(name="Combustibil")
    public String combustibil;

    @Column(name="Putere")
    public int putere;

    @Column(name="Cuplu")
    public int cuplu;

    @Column(name="Volum_portbagaj")
    public int volumPortbagaj;

    @Column(name="Pret")
    public int pret;

}

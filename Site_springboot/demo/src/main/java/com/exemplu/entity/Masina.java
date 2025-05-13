package com.exemplu.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getCapacitateCiindrica() {
        return capacitateCiindrica;
    }

    public void setCapacitateCiindrica(int capacitateCiindrica) {
        this.capacitateCiindrica = capacitateCiindrica;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public int getCuplu() {
        return cuplu;
    }

    public void setCuplu(int cuplu) {
        this.cuplu = cuplu;
    }

    public int getVolumPortbagaj() {
        return volumPortbagaj;
    }

    public void setVolumPortbagaj(int volumPortbagaj) {
        this.volumPortbagaj = volumPortbagaj;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}

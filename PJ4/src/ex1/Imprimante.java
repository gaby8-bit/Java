package ex1;

import java.io.Serializable;

public class Imprimante extends Echipament implements Serializable {
 private int ppm;
 private String rezolutie;
 private int p_car;
 Mod_tiparire tiparire;

    public Imprimante(String denumire, int numar_inv, float pret, StareEchipament stare, int ppm, String rezolutie, int p_car, Mod_tiparire tiparire) {
        super(denumire, numar_inv, pret, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public Mod_tiparire getTiparire() {
        return tiparire;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public void setTiparire(Mod_tiparire tiparire) {
        this.tiparire = tiparire;
    }

    @Override
    public String toString() {
        return super.toString()+"imprimante{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", tiparire=" + tiparire +
                ", stare=" + stare +
                '}';
    }
}

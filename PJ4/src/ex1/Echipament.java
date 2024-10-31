package ex1;

import java.io.Serializable;

public class Echipament implements Serializable {
    private String denumire;
    private int numar_inv;
    private float pret;
    StareEchipament stare;

    public Echipament(String denumire, int numar_inv, float pret, StareEchipament stare) {
        this.denumire = denumire;
        this.numar_inv = numar_inv;
        this.pret = pret;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNumar_inv() {
        return numar_inv;
    }

    public float getPret() {
        return pret;
    }

    public StareEchipament getStare() {
        return stare;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setNumar_inv(int numar_inv) {
        this.numar_inv = numar_inv;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "echipament{" +
                "denumire='" + denumire + '\'' +
                ", numar_inv=" + numar_inv +
                ", pret=" + pret +
                ", stare=" + stare +
                '}';
    }
}

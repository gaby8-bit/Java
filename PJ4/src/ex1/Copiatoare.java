package ex1;

import java.io.Serializable;

public class Copiatoare extends Echipament implements Serializable {
    private int ppt;
   private Mod_copiatoare mod;

    public Copiatoare(String denumire, int numar_inv, float pret, StareEchipament stare, int ppt, Mod_copiatoare mod) {
        super(denumire, numar_inv, pret, stare);
        this.ppt = ppt;
        this.mod = mod;
    }

    public int getPpt() {
        return ppt;
    }

    public Mod_copiatoare getMod() {
        return mod;
    }

    public void setPpt(int ppt) {
        this.ppt = ppt;
    }

    public void setMod(Mod_copiatoare mod) {
        this.mod = mod;
    }

    @Override
    public String toString() {
        return super.toString()+ "copiatoare{" +
                "ppt=" + ppt +
                ", mod=" + mod +
                ", stare=" + stare +
                '}';
    }
}

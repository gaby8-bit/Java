package ex1;

public class Sisteme extends Echipament {
    String tip_mon;
    float vit_proc;
    float c_hdd;
    Sistem_operare sistem;

    public Sisteme(String denumire, int numar_inv, float pret, StareEchipament stare, String tip_mon, float vit_proc, float c_hdd, Sistem_operare sistem) {
        super(denumire, numar_inv, pret, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public float getVit_proc() {
        return vit_proc;
    }

    public float getC_hdd() {
        return c_hdd;
    }

    public Sistem_operare getSistem() {
        return sistem;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }

    public void setC_hdd(float c_hdd) {
        this.c_hdd = c_hdd;
    }

    public void setSistem(Sistem_operare sistem) {
        this.sistem = sistem;
    }

    @Override
    public String toString() {
        return super.toString()+"sisteme{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sistem=" + sistem +
                ", stare=" + stare +
                '}';
    }
}

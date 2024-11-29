package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;

    public static final double alapKamat = 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (getAktualisEgyenleg() - osszeg >= 0) {
            // Kivétel engedélyezve
            return true;
        }
        return false; // Kivétel nem engedélyezve
    }

    public void kamatJovairas() {
        int ujEgyenleg = (int) (getAktualisEgyenleg() * kamat);
        befizet(ujEgyenleg);
    }
}

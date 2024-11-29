package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final double hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, double hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (getAktualisEgyenleg() - osszeg >= -hitelkeret) {
            // Kivétel engedélyezve
            setAktualisEgyenleg((int) (getAktualisEgyenleg() - osszeg));
            return true;
        }
        return false; // Kivétel nem engedélyezve
    }

    public double getHitelKeret() {
        return hitelkeret;
    }
}
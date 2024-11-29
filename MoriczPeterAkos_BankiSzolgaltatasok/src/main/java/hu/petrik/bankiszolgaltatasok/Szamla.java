package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {
    public int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.aktualisEgyenleg = 0;
    }

    public double getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void setAktualisEgyenleg(int aktualisEgyenleg) {
        this.aktualisEgyenleg = aktualisEgyenleg;
    }

    public void befizet(int osszeg) {
        aktualisEgyenleg += osszeg;
    }

    public boolean kivesz(int osszeg) {
        if (aktualisEgyenleg >= osszeg) {
            aktualisEgyenleg -= osszeg;
            return true;
        }
        return false;
    }

    public Kartya ujKarta(String kartyaSzam) {
        return new Kartya(getTulajdonos(), this, kartyaSzam);
    }
}
package hu.petrik.bankiszolgaltatasok;

public class Szamla extends BankiSzolgaltatas {
    public int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.aktualisEgyenleg = 0;
    }

    public double getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void befizet(int osszeg) {
        this.aktualisEgyenleg += osszeg;
    }

    public boolean kivesz(int osszeg) {
        // Nem implementált metódus
        return false;
    }

    public Kartya ujKarta(String kartyaSzam) {
        return new Kartya(getTulajdonos(), this, kartyaSzam);
    }
}
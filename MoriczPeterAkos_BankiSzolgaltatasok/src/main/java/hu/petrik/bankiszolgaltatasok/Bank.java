package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class
Bank {
    private List<Szamla> szamlak;

    public Bank() {
        this.szamlak = new ArrayList<>();
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, double hitelkeret) {
        if (hitelkeret < 0) {
            throw new RuntimeException("Negatív hitelkeret nem érvényes");
        }
        Szamla szamla;
        if (hitelkeret > 0) {
            szamla = new HitelSzamla(tulajdonos, hitelkeret);
        } else {
            szamla = new MegtakaritasiSzamla(tulajdonos);
        }
        szamlak.add(szamla);
        return szamla;
    }

    public double getOsszEgyenleg(Tulajdonos tulajdonos) {
        double osszEgyenleg = 0.0;
        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                osszEgyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return osszEgyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobbEgyenleguSzamla = null;
        double maxEgyenleg = 0.0;
        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos) && szamla.getAktualisEgyenleg() > maxEgyenleg) {
                legnagyobbEgyenleguSzamla = szamla;
                maxEgyenleg = szamla.getAktualisEgyenleg();
            }
        }
        return legnagyobbEgyenleguSzamla;
    }

    public double getOsszHitelkeret() {
        double osszHitelkeret = 0.0;
        for (Szamla szamla : szamlak) {
            if (szamla instanceof HitelSzamla) {
                osszHitelkeret += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszHitelkeret;
    }
}
package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("John Doe");
        Bank bank = new Bank();

        Szamla szamla1 = bank.szamlaNyitas(tulajdonos, 1000.0);
        Szamla szamla2 = bank.szamlaNyitas(tulajdonos, 0.0);
        Szamla szamla3 = bank.szamlaNyitas(tulajdonos, 6000.0);

        szamla1.befizet(1000);
        szamla2.befizet(500);

        Kartya kartya1 = szamla1.ujKarta("1234-5678-9012-3456");
        Kartya kartya2 = szamla2.ujKarta("9876-5432-1098-7654");

        kartya1.vasarlas(200);
        kartya2.vasarlas(300);

        System.out.println("Össz egyenleg: " + bank.getOsszEgyenleg(tulajdonos));
        System.out.println("Legnagyobb egyenlegű számla: " + bank.getLegnagyobbEgyenleguSzamla(tulajdonos));
        System.out.println("Össz hitelkeret: " + bank.getOsszHitelkeret());
    }
}
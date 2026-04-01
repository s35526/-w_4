public class Polisa {

    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis = 0;
    private static final double OPLATA_ADMINISTRACYJNA = 100;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient) {

        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;
    }

    public String getNumerPolisy() {
        return numerPolisy;
    }

    public String getKlient() {
        return klient;
    }

    public double getSkladkaBazowa() {
        return skladkaBazowa;
    }

    public int getPoziomRyzyka() {
        return poziomRyzyka;
    }

    public double getGetSkladkaBazowa() {
        return wartoscPojazdu;
    }

    public boolean getCzyMaAlarm() {
        return czyMaAlarm;
    }

    public boolean isCzyBezszkodowyKlient() {
        return czyBezszkodowyKlient;
    }


    public double obliczSkladkeKoncowa() {
        double skladka = skladkaBazowa + OPLATA_ADMINISTRACYJNA;
        skladka += poziomRyzyka * 120;

        if (wartoscPojazdu > 60000.0) {
            skladka += 200.0;
        }
        if (czyMaAlarm) {
            skladka -= 300.0;
        }
        if (czyBezszkodowyKlient) {
            skladka *= 0.92;
        }
        if (skladka < skladkaBazowa) {
            skladka = skladkaBazowa;
        }

        return Math.round(skladka *100.0)/100.0;
    }
        public double obliczSkladkeOdnowienia() {
        double bazowa = obliczSkladkeKoncowa();
        double odnowieniowa = bazowa;

        if (poziomRyzyka == 4) {
            odnowieniowa *= 1.10;
        } else if (poziomRyzyka >= 5) {
            odnowieniowa *= 1.20;
        }

        if (wartoscPojazdu > 60000.0) {
            odnowieniowa += 150.0;
        }
        if (czyBezszkodowyKlient) {
            odnowieniowa *= 0.92;
        }
        if (czyMaAlarm) {
            odnowieniowa *= 0.95;
        }

        double min = bazowa * 0.90;
        double max = bazowa * 1.25;
        if (odnowieniowa < min) odnowieniowa = min;
        if (odnowieniowa > max) odnowieniowa = max;

        return Math.round(odnowieniowa * 100.0) /100.0;
     }

     public String pobierzPodsumowanieRyzyka() {
        String opis;
        if      (poziomRyzyka <= 1) opis = "bardzo niskie";
        else if (poziomRyzyka == 2) opis = "niskie";
        else if (poziomRyzyka == 3) opis = "srednie";
        else if (poziomRyzyka == 4) opis = "wysokie";
        else                        opis = "bardzo wysokie";

        return "Polisa " + numerPolisy + " [" + klient + "] - poziom ryzyka: " + poziomRyzyka + " (" + opis + ")";
    }

    @Override
    public boolean equals (object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polisa polisa = (Polisa) o;
        return objects.equals(numerPolisy, polisa.numerPolisy);
    }
}
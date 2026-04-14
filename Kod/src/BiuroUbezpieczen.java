import java.util.ArrayList;

public class BiuroUbezpieczen {

    private String nazwa;
    private ArrayList<Polisa> polisy;

    public BiuroUbezpieczen(String nazwa) {
        this.nazwa = nazwa;
        this.polisy = new ArrayList<>();
    }

    public void dodajPolisa(Polisa polisa) {
        polisy.add(polisa);
    }

    public void wypiszRaport() {
        System.out.println("=== RAPORT: " + nazwa + "===");
        for (Polisa p : polisy) {
            System.out.println(p);
        }
        System.out.println("Laczna skladka: " + policzLacznaSkladke());
    }

    public double policzLacznaSkladke() {
        double suma = 0;
        for (Polisa p : polisy) {
            suma += p.obliczSkladkeKoncowa();
        }
        return Math.round(suma * 100.0) / 100.0;
    }

    public double policzLacznaPrognozeOdnowien() {
        double suma = 0;
        for (Polisa  p : polisy) {
            suma += p.obliczSkladkeOdnowienia();
        }
        return Math.round(suma * 100.0) / 100.0;
    }

    public int policzPolisyWysokiegoRyzyka() {
        int licznik = 0;
        for (Polisa p : polisy) {
            if (p.getPoziomRyzyka() >= 4) {
                licznik++;
            }
        }
            return licznik;
        }

    public Polisa znajdzPoNumerze(String numerPolisy) {
        for (Polisa p : polisy) {
            if (p.getNumerPolisy().equals(numerPolisy)) return p;
        }
        return null;
    }

    public void wypiszTanszeNiz(double prog) {
        System.out.println("Polisy ponizej " + prog + "zl:");
        for (Polisa p : polisy) {
            if (p.obliczSkladkeKoncowa() < prog) {
                System.out.println(" " + p);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        BiuroUbezpieczen biuro = new BiuroUbezpieczen("Secure Future");

        Polisa p1 = new Polisa("CAR-101", "Anna Nowak", 900.0, 3, 72000.0, true, true);
        Polisa p2 = new Polisa("CAR-102", "Piotr Lis", 840.0, 4, 54000.0, false, false);
        Polisa p3 = new Polisa("CAR-103", "Karolina Maj", 780.0, 2, 46000.0, true, false);

    biuro.dodajPolisa(p1);
    biuro.dodajPolisa(p2);
    biuro.dodajPolisa(p3);

    biuro.wypiszRaport();

    System.out.println("Laczna składka: " + biuro.policzLacznaSkladke());
    }
}
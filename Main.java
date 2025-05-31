public class Main {
    public static void main(String[] args) {
        try {
            LiqudContainer woda = new LiqudContainer("L", 2500, 3, 200, 500, 300, false);
            woda.load(1800);

            LiqudContainer benzyna = new LiqudContainer("L", 1500, 2, 250, 300, 300, true);
            benzyna.load(600);

            GasContainer nitrous = new GasContainer(1000, 1, 200, 300, 200, 5.0);
            nitrous.load(900);

            RefrigeratedContainer lody = new RefrigeratedContainer(1500, 2, 250, 500, 200, "Paczki lodów", 3.0, 3.0);
            lody.load(200);

           Ship statek = new Ship("G00nma", 5, 20, 30);
            statek.dodajKontener(woda);
            statek.dodajKontener(benzyna);
            statek.dodajKontener(nitrous);
            statek.dodajKontener(lody);

            statek.wypiszInformacje();
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd danych: " + e.getMessage());
        } catch (OverfillException e) {
            System.out.println("Błąd załadunku: " + e.getMessage());
        }
    }
}

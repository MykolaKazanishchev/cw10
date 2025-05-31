import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String nazwa;
    private int maksLiczbaKontenerow;
    private double maksWagaLadunku;
    private double predkosc;
    private List<Container> kontenery = new ArrayList<>();

    public Ship(String nazwa, int maksLiczbaKontenerow, double maksWagaLadunku, double predkosc) {
        this.nazwa = nazwa;
        this.maksLiczbaKontenerow = maksLiczbaKontenerow;
        this.maksWagaLadunku = maksWagaLadunku;
        this.predkosc = predkosc;
    }

    public boolean dodajKontener(Container kontener) {
        double wagaLaczna = kontener.wagaWlasna + kontener.masaLadunku;

        if (kontenery.size() >= maksLiczbaKontenerow) {
            System.out.println("Za dużo kontenerów na statku.");
            return false;
        }

        if ((obliczWageCalkowita() + wagaLaczna) > maksWagaLadunku * 1000) {
            System.out.println("Maksymalna waga statku została przekroczona.");
            return false;
        }

        kontenery.add(kontener);
        return true;
    }

    public boolean usunKontener(String numerSeryjny) {
        return kontenery.removeIf(c -> c.getNumerSeryjny().equals(numerSeryjny));
    }

    public boolean zamienKontener(String numerSeryjny, Container nowy) {
        for (int i = 0; i < kontenery.size(); i++) {
            if (kontenery.get(i).getNumerSeryjny().equals(numerSeryjny)) {
                kontenery.set(i, nowy);
                return true;
            }
        }
        return false;
    }

    public void przeniesKontenerDo(Ship inny, String numerSeryjny) {
        for (Container c : kontenery) {
            if (c.getNumerSeryjny().equals(numerSeryjny)) {
                if (inny.dodajKontener(c)) {
                    kontenery.remove(c);
                    break;
                }
            }
        }
    }

    public double obliczWageCalkowita() {
        return kontenery.stream().mapToDouble(c -> c.wagaWlasna + c.masaLadunku).sum();
    }

    public void wypiszInformacje() {
        System.out.println("STATEK: " + nazwa);
        System.out.println("Prędkość: " + predkosc + " węzłów");
        System.out.println("Kontenery: " + kontenery.size() + "/" + maksLiczbaKontenerow);
        System.out.printf("Całkowita waga: %.2f kg (maks %.2f t)", obliczWageCalkowita(), maksWagaLadunku);
        for (Container c : kontenery) {
            System.out.println("- " + c.getNumerSeryjny() + "   " + c.getClass().getSimpleName() + " Ładunek: " + c.masaLadunku + " kg");
        }
    }
}
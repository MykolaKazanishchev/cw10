public class GasContainer extends Container implements IHazardNotifier {
    private double cisnienie;

    public GasContainer(double maksymalnaLadownosc, double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, double cisnienie) {
        super("G", maksymalnaLadownosc, masaLadunku, wysokosc, wagaWlasna, glebokosc);
        this.cisnienie = cisnienie;
    }

    @Override
    public void load(double masa) throws OverfillException {
        if (masa > maksymalnaLadownosc) {
            notifyHazard("Próba przeładowania kontenera gazowego");
            throw new OverfillException("Za duży ładunek do kontenera gazowego");
        }
        this.masaLadunku = masa;
    }

    @Override
    public void unload() {
        this.masaLadunku *= 0.05;
    }



    @Override
    public void notifyHazard(String message, String numerSeryjny) {
        System.out.println("Gaz " + message + " Kontener: " + numerSeryjny);
    }

    @Override
    public void notifyHazard(String message) {

    }

}


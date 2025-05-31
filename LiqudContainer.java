public class LiqudContainer extends Container implements IHazardNotifier{
    private boolean hazardous;

    public LiqudContainer(String type, double maksymalnaLadownosc, double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, boolean niebezpieczny) {
        super(type, maksymalnaLadownosc, masaLadunku, wysokosc, wagaWlasna, glebokosc);
        this.hazardous = hazardous;
    }

    @Override
    public void load(double wagaWlasna) throws OverfillException {
        double limit = hazardous ? 0.5 : 0.9;
        if (wagaWlasna > maksymalnaLadownosc * limit) {
            notifyHazard("Za dużo ładunku", getNumerSeryjny());
            throw new OverfillException("Przekroczono limit masy!");
        }
        masaLadunku = wagaWlasna;
    }



    @Override
    public void notifyHazard(String message, String containerSerialNumber) {
        System.out.println("UWAGA" + message + " " + numerSeryjny + " ");
    }

    @Override
    public void notifyHazard(String message) {

    }
}

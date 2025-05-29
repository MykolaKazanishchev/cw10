public abstract class Container {
    protected double masaLadunku;
    protected double maksymalnaLadownosc;
    protected double wysokosc;
    protected double wagaWlasna;
    protected double glebokosc;
    protected String numerSeryjny;

    private static int idCounter = 1;

    public Container(String type,double maksymalnaLadownosc, double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc) {
        this.numerSeryjny = "KON-" + type + "-" + idCounter++;
        this.maksymalnaLadownosc = maksymalnaLadownosc;
        this.masaLadunku = 0;
        this.wysokosc = wysokosc;
        this.wagaWlasna = wagaWlasna;
        this.glebokosc = glebokosc;
    }
    public String getNumerSeryjny() {
        return numerSeryjny;
    }
    public void unload(){
        masaLadunku = 0;
    }
    public abstract void load(double weight) throws OverfillException;
}

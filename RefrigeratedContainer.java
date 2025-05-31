public class RefrigeratedContainer extends Container {
    private String typProduktu;
    private double wymaganaTemperatura;
    private double temperaturaKontenera;

    public RefrigeratedContainer(double maksymalnaLadownosc, double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String typProduktu, double wymaganaTemp, double tempKontenera) {
        super("C", maksymalnaLadownosc, masaLadunku, wysokosc, wagaWlasna, glebokosc);
        this.typProduktu = typProduktu;
        this.wymaganaTemperatura = wymaganaTemp;
        this.temperaturaKontenera = tempKontenera;

        if (temperaturaKontenera > wymaganaTemperatura) {
            throw new IllegalArgumentException("Zbyt wysoka temperatura dla tego produktu: " + typProduktu);
        }
    }
    @Override
    public void load(double masa) throws OverfillException{
    if (masa > maksymalnaLadownosc) {
        throw new OverfillException("Przekroczono maksymalna ladownosc refrigeratora");
    }
    this.masaLadunku = masa;
    }
}
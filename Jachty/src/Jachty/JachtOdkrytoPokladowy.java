package Jachty;

public class JachtOdkrytoPokladowy extends JachtyZaglowe {
    protected String typ = "Jacht Odkrytopokładowy";

    public JachtOdkrytoPokladowy(int ciezar, String producent, int dlugosc, int zanurzenie, int powierzchniaozaglowania) {
        super(ciezar, producent, dlugosc, zanurzenie, powierzchniaozaglowania);
        this.setTyp(typ);
    }
}

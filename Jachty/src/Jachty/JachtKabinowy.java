package Jachty;

public class JachtKabinowy extends JachtyZaglowe {
    protected String typ = "Jacht Kabinowy";

    public JachtKabinowy(int ciezar, String producent, int dlugosc, int zanurzenie, int powierzchniaozaglowania) {
        super(ciezar, producent, dlugosc, zanurzenie, powierzchniaozaglowania);
        this.setTyp(typ);
    }
}

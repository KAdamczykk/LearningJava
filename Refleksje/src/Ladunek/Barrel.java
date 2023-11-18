package Ladunek;

public class Barrel extends Cargo{


    public Barrel(int szerokosc, int wysokosc) {
        super(szerokosc, wysokosc);
    }

    public Barrel(int szerokosc, int wysokosc, int masa) {
        super(szerokosc, wysokosc, masa);
    }

    @Override
    public int Objetosc() {
        return getSzerokosc() * getWysokosc();
    }
    @Override
    public void WypiszObjetosc() {
        System.out.println(Objetosc());
    }
}

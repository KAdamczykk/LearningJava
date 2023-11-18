package Ladunek;

public class BagOfPotatoes extends Cargo{
    public BagOfPotatoes(int szerokosc, int wysokosc) {
        super(szerokosc, wysokosc);
    }

    public BagOfPotatoes(int szerokosc, int wysokosc, int masa) {
        super(szerokosc, wysokosc, masa);
    }
    private int objetosc(){
        return getSzerokosc() * getWysokosc();
    }
    private void hello(String str){
        System.out.println(str);
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

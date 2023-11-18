package Ladunek;

public class Chest extends Cargo{

    private String name; // test
    private boolean bool; // test

    public Chest(int szerokosc, int wysokosc) {
        super(szerokosc, wysokosc);
    }

    public Chest(int szerokosc, int wysokosc, int masa) {
        super(szerokosc, wysokosc, masa);
    }

   // public Chest(String name, boolean bool){super(0,0,0);this.setName(name); this.setBool(bool);} //test


    public void setName(String name) {
        this.name = name;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }


    public String getName() {
        return name;
    }



    public boolean isBool() {
        return bool;
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

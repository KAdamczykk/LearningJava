package Ladunek;

import ExampleInterface.WypiszObjetosc;

public abstract class Cargo implements ObjetoscInterfejs, WypiszObjetosc {
    private int szerokosc, wysokosc, masa;
    public Cargo(int szerokosc, int wysokosc){
        this.setSzerokosc(szerokosc); this.setWysokosc(wysokosc);
    }
    public Cargo(int szerokosc, int wysokosc, int masa){
        this.setWysokosc(wysokosc); this.setSzerokosc(szerokosc); this.setMasa(masa);
    }



    public void setSzerokosc(int szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public int getMasa() {
        return masa;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +", o wysokosci: "+this.getWysokosc() +", szerekosci: " + this.getSzerokosc() +" i masie: "+this.getMasa();
    }
}

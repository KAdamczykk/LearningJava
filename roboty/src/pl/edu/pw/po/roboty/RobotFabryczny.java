package pl.edu.pw.po.roboty;

import java.util.Random;

public abstract class RobotFabryczny extends Robot{
    /**
     * jr
     * Konstruktor powinien przyjmować zadanie (-0.5)
     * */
    RobotFabryczny(lancuch nazwa, SztucznaInteligencja.reprezentacja_danych si) {
        super(nazwa, si);
        zad = zadanie[ran.nextInt(1,6)];
    }

    enum Zadanie {skrawanie, zgrzewanie, modelowanie, podnosnik, lakierowanie, sklejanie}
    Zadanie[] zadanie = Zadanie.values();
    Zadanie zad;
    Random ran = new Random();
    int index = ran.nextInt(1,6);
    /**
     * jr
     * Ta metoda powinna być zaimplementowana w klasie bazowej (-0.5)*/
    public void zadanieWykonaj(){
        int ilosc = ran.nextInt(1,20);
        ileZadan = ileZadan + ilosc;
    }

    @Override
    public String toString() {
        return super.toString() + ". Robot wykonuje zadanie: " +this.zad;
    }
}

package pl.edu.pw.po.roboty;

import pl.edu.pw.po.zasoby.PorozumiewaniePlus;

public class RobotDomowy extends Robot implements PorozumiewaniePlus {
    public RobotDomowy(lancuch nazwa, SztucznaInteligencja.reprezentacja_danych si) {
        super(nazwa,si);
    }

    @Override
    public void powitanie() {
        System.out.println(this.getNazwa() + " o nr fabrycznym " + nr_fab + " mowi witaj");
    }
}

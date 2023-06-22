package pl.edu.pw.po.roboty;

import pl.edu.pw.po.zasoby.PorozumiewaniePlus;

public final class RobotSkladanie extends RobotFabryczny implements PorozumiewaniePlus {
    private int limit = ran.nextInt(1,10);

    public RobotSkladanie(lancuch nazwa, SztucznaInteligencja.reprezentacja_danych si) {
        super(nazwa, si);

    }
    public int getLimit(){
        return limit;
    }

    @Override
    public void zadanieWykonaj() {
        int ilosc = ran.nextInt(1,20);
        int tmp = ileZadan + ilosc;
        if (tmp > getLimit()){
            System.out.println("Przekroczono limit");

        } else {
            ileZadan = ileZadan + limit;
        }

    }

    @Override
    public int meldunek() {
        int pozostale = limit - ileZadan;
        return super.meldunek() + pozostale;
    }

    @Override
    public void powitanie() {
        System.out.println(this.getNazwa() + " o nr fabrycznym " + nr_fab + " mowi witaj");
    }
}

package pl.edu.pw.po.zasoby;

public interface PorozumiewaniePlus extends Porozumienie{
    /**
     * jr
     * meldunek jest dziedziczony, wiec tu niepotrzebny (-0.5)
     * */
    @Override
    int meldunek();
    void powitanie();
}

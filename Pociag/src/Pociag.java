import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public  class Pociag {
    Random random = new Random();
    Lokomotywa lokomotywa = new Lokomotywa();
    Kierownik kierownik = new Kierownik();
    private final Konduktor konduktor1 = new Konduktor();
    private final Konduktor konduktor2 = new Konduktor();
    private final Konduktor konduktor3 = new Konduktor();
    private List<Konduktor> konduktorzy = new ArrayList<>();
    private void setKonduktorzy(){
        konduktorzy.add(konduktor1);
        konduktorzy.add(konduktor2);
        konduktorzy.add(konduktor3);
    }
    LinkedHashMap<Integer, Wagon> ciufcia = new LinkedHashMap<>();
    private final int iloscWagonow = losujIloscWagonow();
    public Pociag(){
        this.uzuplnij(this.iloscWagonow);
        this.setKonduktorzy();
    }

    public List<Konduktor> getKonduktorzy() {
        return konduktorzy;
    }

    private int losujIloscWagonow(){
        int losuj = random.nextInt(5,16);
        return losuj;
    }
    private void uzuplnij(int ilosc){
        for (int i = 0; i < ilosc; i++){
            int ilosc_pzedzialow = random.nextInt(6,11);
            Wagon wagon = new Wagon(ilosc_pzedzialow);
            ciufcia.put(i, wagon);
        }
    }

    public int getIloscWagonow() {
        return iloscWagonow;
    }
}

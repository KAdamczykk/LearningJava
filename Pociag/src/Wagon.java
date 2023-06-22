import java.util.LinkedHashMap;
import java.util.Random;

public class Wagon {
    private int liczbaPrzedzialow;
    Random random = new Random();
    private final int ilosc_osob = this.losujIleOsobowy();
    private LinkedHashMap<Integer, Przedzial> przedzialy = new LinkedHashMap<>();
    Korytarz korytarz = new Korytarz();

    public Wagon(int liczbaPrzedzialow) {

        this.setLiczbaPrzedzialow(liczbaPrzedzialow);

        this.uzupelnijPrzedzialy();
    }

    public void setLiczbaPrzedzialow(int liczbaPrzedzialow) {
        this.liczbaPrzedzialow = liczbaPrzedzialow;
    }
    private int losujIleOsobowy(){
        int r = random.nextInt(0,2);
        if (r == 0){
            return 6;
        }else {
            return 8;
        }
    }

    public int getIlosc_osob() {
        return ilosc_osob;
    }
    private void uzupelnijPrzedzialy(){
        for (int i = 0; i < liczbaPrzedzialow; i++){
            Przedzial przedzial = new Przedzial(ilosc_osob);
            przedzialy.put(i, przedzial);
        }
    }


    public LinkedHashMap<Integer, Przedzial> getPrzedzialy() {
        return przedzialy;
    }
}

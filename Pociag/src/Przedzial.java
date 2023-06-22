import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class Przedzial {
    private static int counter = 0;
    Random random = new Random();
    private int liczbaosob;
    private Stos<Bagaz> stos = new Stos<>();

    private LinkedHashMap<Integer, Pasazer> uklad = new LinkedHashMap<>();

    public Przedzial(int liczba_osob){
        counter = 0;
        this.liczbaosob = liczba_osob;
    }

    public int getLiczbaosob() {
        return liczbaosob;
    }

    public void addPasazer(Pasazer pasazer){
        uklad.put(counter, pasazer);
        counter++;
    }

    public LinkedHashMap<Integer, Pasazer> getUklad() {
        return uklad;
    }
    public void DodajBagaze(List<Bagaz> list){
        while (!list.isEmpty()){
            Bagaz bagaz = list.get(0);
            list.remove(0);
            stos.push(bagaz);
        }
    }

    public Stos<Bagaz> getStos() {
        return stos;
    }
}

import java.time.LocalDate;
import java.util.*;

public class Kasa {
    private List< Produkt> koszyk = new ArrayList<>();
    public Kasa(){}
    public void addKoszyk(Produkt produkt) throws PrzeterminowaneException{
        if (produkt.getDataW().isBefore(LocalDate.now())){
            throw new PrzeterminowaneException("Przeterminowane");
        } else if (produkt instanceof Pieczywo && Pieczywo.counter == 3) {
            produkt.setCena(0);
            koszyk.add(produkt);
        } else{
            koszyk.add(produkt);
        }

    }
    public double getCena(Produkt produkt) {
        return produkt.getCena();
    }


    public boolean czyPrzeceniony(Produkt produkt){
        if (produkt.getCena() != produkt.getCenaWyjsciowa()){
            return true;
        } else {
            return false;
        }
    }
    public double podajRabat(Produkt produkt){
        if (czyPrzeceniony(produkt)){
        return produkt.Rabat();} else{
            return 0;
        }
    }
    public double sumaCen(List < Produkt> koszyk){
        Iterator<Produkt> iterator = koszyk.iterator();
        double suma = 0;
        while (iterator.hasNext()){
            Produkt produkt = iterator.next();
            suma = suma + produkt.getCena();
        }
        return suma;
    }
    public double Zaplac(List<Produkt> koszyk, double platnosc){
        return platnosc - sumaCen(koszyk);
    }
    public String Paragon(List<Produkt> koszyk){
        String str = "";
        Iterator<Produkt> iterator = koszyk.iterator();
        while (iterator.hasNext()){
            Produkt produkt = iterator.next();
            str = str + "" + produkt + "    " + produkt.getCena() + "\n";

        }
        return str;
    }

    public List<Produkt> getKoszyk() {
        return koszyk;
    }
}

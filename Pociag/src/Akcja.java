import java.util.HashMap;
import java.util.Iterator;

public class Akcja {
    public static void main(String[] args) {
        Pociag pociag = new Pociag();
        Peron peron = new Peron();
        for (int i = 0; i < 500; i++){
            int nrWagonu = pociag.kierownik.losujWagon(pociag.getIloscWagonow());
            Pasazer pasazer = peron.kolejkaPeronowa.get(i);
            Wagon wagon = pociag.ciufcia.get(nrWagonu);
            HashMap<Integer, Przedzial> przedzialy = wagon.getPrzedzialy();
            boolean z = true;
            for (int j = 0; j < przedzialy.size(); j++){
                if (przedzialy.get(j).getUklad().size() < przedzialy.get(j).getLiczbaosob()){
                    przedzialy.get(j).addPasazer(pasazer);
                    System.out.println("Dodano pasazera nr " +i +" do przedzialu nr " + j + " w wagonie nr " +nrWagonu);
                    przedzialy.get(j).DodajBagaze(pasazer.getBagaze());
                    System.out.println("Pasazer zapakowal swoje bagaze ");
                    z= false;
                    break;
                }
            }
            if (z){
                wagon.korytarz.addPerson(pasazer);
                System.out.println("Pasazer nr " + i + " stoi na korytarzu w wagonie " +nrWagonu);
            }
            peron.kolejkaPeronowa.remove(i);
        }
        boolean start = pociag.lokomotywa.go();
        if (!start) {
            for (int i = 0; i < pociag.getIloscWagonow(); i++){
                pociag.ciufcia.get(i).korytarz.getMapa().clear();
                pociag.ciufcia.get(i).getPrzedzialy().clear();
            }
            System.exit(0);
        }
        for (int i = 0; i < pociag.getIloscWagonow(); i ++){
            Wagon wagon = pociag.ciufcia.get(i);
            Iterator<Integer> it = wagon.korytarz.getMapa().keySet().iterator();
            for (int j = 0; j < wagon.korytarz.getMapa().size(); j++){
                if (!wagon.korytarz.getMapa().get(it.next()).getBilet()){
                    pociag.lokomotywa.stop();
                    wagon.korytarz.getMapa().remove(it);
                    System.out.println("Gapowicz usuniety");
                    if(!pociag.lokomotywa.go()){
                        for (int z = 0; z < pociag.getIloscWagonow(); z++){
                            pociag.ciufcia.get(i).korytarz.getMapa().clear();
                            pociag.ciufcia.get(i).getPrzedzialy().clear();
                        }
                        System.exit(0);
                    }
                }
            }
            for (int k = 0; k < wagon.getPrzedzialy().size(); k++){
                Przedzial przedzial = wagon.getPrzedzialy().get(k);
                Iterator<Integer> iterator = przedzial.getUklad().keySet().iterator();
                while (iterator.hasNext()){
                    if (!przedzial.getUklad().get(iterator.next()).getBilet()){
                        pociag.lokomotywa.stop();
                        wagon.korytarz.getMapa().remove(iterator);
                        System.out.println("Gapowicz usuniety");
                        if(!pociag.lokomotywa.go()){
                            for (int z = 0; z < pociag.getIloscWagonow(); z++){
                                pociag.ciufcia.get(i).korytarz.getMapa().clear();
                                pociag.ciufcia.get(i).getPrzedzialy().clear();
                            }
                            System.exit(0);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < pociag.getIloscWagonow(); i ++){
            Wagon wagon = pociag.ciufcia.get(i);
            System.out.println("Wagon nr: " + i + " na korytarzu: " +  wagon.korytarz.getMapa().size());

            for (int k = 0; k < wagon.getPrzedzialy().size(); k++){
                Przedzial przedzial = wagon.getPrzedzialy().get(k);
                System.out.println("Wagon nr: " + i + " przedział: " +k + " liczba osob " + przedzial.getUklad().size());
                }
            }
        System.out.println("Pociag dojechal do celu");
        }


}

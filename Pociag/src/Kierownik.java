import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kierownik {
    Random random = new Random();
    public Kierownik(){}
    public int losujWagon(int iloscWagonow){
        return random.nextInt(0, iloscWagonow);
    }
    public Konduktor LosujKonduktora(List<Konduktor> konduktors){
        int index = random.nextInt(0, konduktors.size());
        return konduktors.get(index);
    }
}

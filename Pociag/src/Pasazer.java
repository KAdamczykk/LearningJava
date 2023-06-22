import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pasazer {
    Bilet bilet;
    Random random = new Random();
    private int iloscBagazy = random.nextInt(1,4);
    private List<Bagaz> bagaze = new ArrayList<>();
    public Pasazer(){
        this.tworzBagaze(iloscBagazy);
    }
    private void tworzBagaze(int iloscBagazy){
        for (int i = 0; i < iloscBagazy; i++){
            Bagaz bagaz = new Bagaz();
            bagaze.add(bagaz);
        }

    }

    public List<Bagaz> getBagaze() {
        return bagaze;
    }
    public boolean getBilet(){
        double prawdopodobienstwo = random.nextDouble(0,1);
        if (prawdopodobienstwo<0.05){
            return false;
        }
        return true;
    }
}

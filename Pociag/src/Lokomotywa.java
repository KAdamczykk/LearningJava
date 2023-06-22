import java.util.Random;

public class Lokomotywa  implements Ruch{

    @Override
    public boolean stop() {
        System.out.println("Pociag stoi");
        return false;
    }

    @Override
    public boolean go() {
        Random random = new Random();
        double prawdopodobienstwo = random.nextDouble(0,1);
        if (prawdopodobienstwo < 0.05) {
            System.out.println("Koniec Jazdy");
            return false;
        }
        System.out.println("Pociag ruszyl");
        return true;
    }

}

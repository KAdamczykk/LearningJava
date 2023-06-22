import java.util.Random;

public class Chalkolit extends Obiekty_Kopaniane{
    Random random = new Random();
    int radioaktywnosc = random.nextInt(700, 950);
    double wart_rynkowa;
    public Chalkolit(double wart_rynkowa){
        this.wart_rynkowa = wart_rynkowa;
    }

    @Override
    public double getModifiedMarketValue() {
        return this.wart_rynkowa;
    }
}

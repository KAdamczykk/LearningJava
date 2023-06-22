import java.util.Random;

public class Uraninit extends Obiekty_Kopaniane{
    Random random = new Random();
    int radioaktywnosc = random.nextInt(700, 950);
    String[] kategoria = {"uranofan",  "torbernit",  "foumarieryt"};
    String kat;





    public Uraninit(double wart_rynkowa, int index){
        this.wart_rynkowa = wart_rynkowa;
        this.kat = kategoria[index];




    }

    @Override
    public double getModifiedMarketValue() {
        double wr = this.wart_rynkowa;
        if (this.kat == "uranofan") {
            wr = wr * 1;
        } else if (this.kat == "torbernit") {
            wr = wr * 1.5;
        } else if (this.kat == "foumarieryt") {
            wr = wr* 2.5;
        }
        return wr;
    }
}

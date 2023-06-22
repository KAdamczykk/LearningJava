public class Skala extends Obiekty_Kopaniane{
    final double wart_rynkowa = 1;

    @Override
    public double getModifiedMarketValue() {
        return this.wart_rynkowa;
    }
}

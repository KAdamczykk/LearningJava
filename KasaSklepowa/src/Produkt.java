import java.time.LocalDate;
import java.util.Random;

public abstract class Produkt implements Discount,ExpireDate{
    private double cena;
    private double cenaWyjsciowa;
    private LocalDate dataW;
    Random random = new Random();
    Produkt(double cena){
        this.setCena(cena);
        final double cenaWyjsciowa = cena;
        setDataW(this.dataWaznosci());
        int wart = this.LosujCzyMaDiscount();
        if (wart == 0){
            this.Rabat();
        }
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCenaWyjsciowa(double cenaWyjsciowa) {
        this.cenaWyjsciowa = cenaWyjsciowa;
    }

    @Override
    public double Rabat() {
        double rabat = random.nextDouble(0.05,0.5);
        this.setCena(this.getCena() * (1 - rabat));
        return rabat;
    }

    public double getCenaWyjsciowa() {
        return cenaWyjsciowa;
    }

    @Override
    public LocalDate dataWaznosci() {
        int dzien;
        int miesiac = random.nextInt(1,12);
        if (miesiac == 2){
            dzien =  random.nextInt(1,29);
        } else {
            dzien = random.nextInt(1,31);
        }

        LocalDate data = LocalDate.of(2023, miesiac,dzien);

        return data;
    }

    public void setDataW(LocalDate dataW) {
        this.dataW = dataW;
    }

    public LocalDate getDataW() {
        return dataW;
    }
    private int LosujCzyMaDiscount(){
        return random.nextInt(0,2);
    }

    @Override
    public String toString() {
        return "Produkt: " + this.getClass();
    }
}

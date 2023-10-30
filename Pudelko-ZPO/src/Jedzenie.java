import java.util.function.Supplier;

public abstract class Jedzenie extends Gadzety {
    private String producent;
    private int kalorycznosc;
    Jedzenie(Supplier<String> producent, Supplier<Integer> kalorycznosc){
        this.setProducent(producent.get());
        this.setKalorycznosc(kalorycznosc.get());
    }

    @Override
    public String toString() {
        return ", producent: " + this.producent + ", kalorycznosc: " + this.kalorycznosc;
    }

    public void setKalorycznosc(int kalorycznosc) {
        this.kalorycznosc = kalorycznosc;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getKalorycznosc() {
        return kalorycznosc;
    }

    public String getProducent() {
        return producent;
    }

    public static class Puszka extends Jedzenie{

        Puszka(Supplier<String> producent, Supplier<Integer> kalorycznosc) {
            super(producent, kalorycznosc);

        }

        @Override
        public String toString() {
            return "Puszka"+super.toString();
        }
    }
    public static class Paczka extends Jedzenie{

        Paczka(Supplier<String> producent, Supplier<Integer> kalorycznosc) {
            super(producent, kalorycznosc);

        }

        @Override
        public String toString() {
            return "Paczka"+super.toString();
        }
    }
}

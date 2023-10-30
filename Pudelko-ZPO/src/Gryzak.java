import java.util.function.Supplier;

public class Gryzak extends Gadzety {
    private String nazwaProducenta;
    private boolean atest;
    Gryzak(Supplier<String> producerNameGenerator, Supplier<Boolean> attestationGenerator){
        this.setAtest(attestationGenerator.get());
        this.setNazwaProducenta(producerNameGenerator.get());
    }

    public void setAtest(boolean atest) {
        this.atest = atest;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public String getNazwaProducenta() {
        return nazwaProducenta;
    }

    public boolean isAtest() {
        return atest;
    }


    @Override
    public String toString() {
        return "Gryzak, producent: " + this.nazwaProducenta+ ", atest: " +this.atest;
    }
}

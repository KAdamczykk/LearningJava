import java.util.function.Supplier;

public class GryzakPiszczacy extends Gryzak{
    private int pisk;

    GryzakPiszczacy(Supplier<String> producerNameGenerator, Supplier<Boolean> attestationGenerator, Supplier<Integer> frequencyGenerator) {
        super(producerNameGenerator, attestationGenerator);
        this.setPisk(frequencyGenerator.get());
    }



    public void setPisk(int pisk) {
        this.pisk = pisk;
    }

    public int getPisk() {
        return pisk;
    }

    @Override
    public String toString() {
        return "Pisczacy " + super.toString() + ", czestotliwosc: " + this.pisk;
    }
}

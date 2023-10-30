import java.util.Random;
import java.util.function.Supplier;

public class InitHelper {
    private Random random = new Random();
    public Supplier<String> provideRandomProducerNameGenerator(){
        String[] producerNames = {"DINGO", "FAFIK", "My pet", "LAPA", "CERBER", "raBIES"};
        return () -> producerNames[random.nextInt(0, producerNames.length)];
    }
    public Supplier<Integer> provideRandomFrequencyGenerator(){
        return () -> random.nextInt(0,5) * 2 + 16;
    }
    public Supplier<Boolean> provideRandomAttestationGenerator(boolean alwaysTrue) {
        return () -> alwaysTrue || random.nextDouble() < 0.95 ? true : false;
    }
    public Supplier<Integer> provideRandomCaloriesValue(int x, int y) {
        return () -> random.nextInt(x,y+1);
    }



}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBox {
    private List<Gadzety> list = new ArrayList<>();
    Random random = new Random();
    MyBox(){
        InitHelper initHelper = new InitHelper();
        for (int i = 0; i < 50; i++){
            if (i < 20) {
                list.add(new Gryzak(initHelper.provideRandomProducerNameGenerator(), initHelper.provideRandomAttestationGenerator(true)));
                list.add(new GryzakPiszczacy(initHelper.provideRandomProducerNameGenerator(), initHelper.provideRandomAttestationGenerator(false), initHelper.provideRandomFrequencyGenerator() ));
            }
            if (i < 40) {
                list.add(new Jedzenie.Puszka(initHelper.provideRandomProducerNameGenerator(), initHelper.provideRandomCaloriesValue(100,150)));
            }
            list.add(new Jedzenie.Paczka(initHelper.provideRandomProducerNameGenerator(), initHelper.provideRandomCaloriesValue(300,400)));

        }
        counter =0;


    }

    public List<Gadzety> getList() {
        return list;
    }

    public void detectNonAttestationChew(){
        list.forEach(akcesorium -> {
            if (akcesorium instanceof Gryzak || akcesorium instanceof GryzakPiszczacy){
                if (!((Gryzak) akcesorium).isAtest()){
                    System.out.println("BRAK ATESTU!!!");
                }
            }
        } );
    }
    private static int counter;
    public void detectCaloricFood(){
        list.forEach(akces -> {
            if (akces instanceof Jedzenie && counter < 32){
                System.out.println("Uwaga na kalorie");
                counter++;
            }
        });
    }
    public int getSummarizedDryFoodCalories(){
        AtomicInteger count = new AtomicInteger(0);
        list.forEach(akces -> {
            if (akces instanceof Jedzenie.Paczka){
                count.addAndGet(((Jedzenie.Paczka) akces).getKalorycznosc());
            }
        });
        return count.get();
    }
    public class InMyBox extends MyBox{
        public void upgradeProducerName(String newName){
            list.forEach(elem -> {
                if ((elem instanceof Gryzak)){
                    if (((Gryzak) elem).getNazwaProducenta().length() <= 5){
                        ((Gryzak) elem).setNazwaProducenta(newName);}
                }
                if ((elem instanceof Jedzenie)){
                    if (((Jedzenie) elem).getProducent().length() <= 5){
                    ((Jedzenie) elem).setProducent(newName);}
                }
            });
        }
        public void upgradeFrequency4All(){
            int monoz = random.nextInt(0,5)*2 + 16;
            AtomicInteger in = new AtomicInteger(monoz);
            list.forEach(elem -> {
                if (elem instanceof GryzakPiszczacy){
                    ((GryzakPiszczacy) elem).setPisk(in.get());
                }
            });
        }
        public int getAverageWetFoodCalories(){
            AtomicInteger count = new AtomicInteger(0);
            AtomicInteger sum = new AtomicInteger(0);
            list.forEach(elem -> {
                if (elem instanceof Jedzenie.Puszka){
                    sum.addAndGet(((Jedzenie.Puszka) elem).getKalorycznosc());
                    count.incrementAndGet();
                }
            });
            return sum.get() / count.get();
        }
    }

}

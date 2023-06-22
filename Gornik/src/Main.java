public class Main {
    public static void main(String[] args) {
       // Adit adit = new Adit(4,8,4);
       // Object[][] plansza = adit.uzupelnijPlansze();
       // System.out.println(adit.WypiszPlonsze(plansza));
        Gornik gornik = new Gornik(4,8,4);
        Object[][] tab = gornik.uzupelnijPlansze();
        System.out.println(gornik.WypiszPlonsze(tab));
        System.out.println(gornik.goMiner(tab));
        System.out.println(gornik.WypiszPlonsze(tab));


    }
}
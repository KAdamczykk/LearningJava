import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Kasa kasa = new Kasa();
        Chemia chemia = new Chemia(15);
        Inne inne = new Inne(24);
        Nabial nabial = new Nabial(10);
        Odziez odziez = new Odziez(200);
        OwoceIWarzywa owoceIWarzywa = new OwoceIWarzywa(7, 2);
        Mieso mieso = new Mieso(19, 2.3);
        Pieczywo pieczywo = new Pieczywo(2.5);
        try {
            kasa.addKoszyk(chemia);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(inne);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(mieso);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(nabial);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(odziez);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(owoceIWarzywa);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        try {
            kasa.addKoszyk(pieczywo);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        Pieczywo pieczywo1 = new Pieczywo(2.5);
        try {
            kasa.addKoszyk(pieczywo1);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        Pieczywo pieczywo2 = new Pieczywo(2.5);
        try {
            kasa.addKoszyk(pieczywo2);
        } catch (PrzeterminowaneException e) {
            System.out.println(e);
        }
        int var = random.nextInt(0, kasa.getKoszyk().size());
        System.out.println(kasa.getCena(kasa.getKoszyk().get(var)));
        var = random.nextInt(0, kasa.getKoszyk().size());
        System.out.println(kasa.czyPrzeceniony(kasa.getKoszyk().get(var)));
        var = random.nextInt(0, kasa.getKoszyk().size());
        System.out.println(kasa.podajRabat(kasa.getKoszyk().get(var)));
        System.out.println("reszta:" + kasa.Zaplac(kasa.getKoszyk(), 1000));
        System.out.println("Paragon \n" + kasa.Paragon(kasa.getKoszyk()) );


        KolejkaDwustronnaGeneryczna<Integer> integerKolejkaDwustronnaGeneryczna = new KolejkaDwustronnaGeneryczna<>();
        System.out.println(integerKolejkaDwustronnaGeneryczna.isEmpty());
        integerKolejkaDwustronnaGeneryczna.pushFront(2);
        integerKolejkaDwustronnaGeneryczna.pushFront(7);
        integerKolejkaDwustronnaGeneryczna.pushFront(8);
        integerKolejkaDwustronnaGeneryczna.pushFront(9);
        integerKolejkaDwustronnaGeneryczna.pushFront(2);
        integerKolejkaDwustronnaGeneryczna.pushFront(3);
        integerKolejkaDwustronnaGeneryczna.pushFront(1);
        integerKolejkaDwustronnaGeneryczna.pushFront(0);
        integerKolejkaDwustronnaGeneryczna.pushFront(11);
        System.out.println(integerKolejkaDwustronnaGeneryczna);
        integerKolejkaDwustronnaGeneryczna.pushLast(33);
        integerKolejkaDwustronnaGeneryczna.popFirst();
        integerKolejkaDwustronnaGeneryczna.popLast();
        integerKolejkaDwustronnaGeneryczna.pushLast(33);
        System.out.println(integerKolejkaDwustronnaGeneryczna);

    }
}
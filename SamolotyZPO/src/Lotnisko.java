import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Lotnisko {
    private List<Samolot> list = new ArrayList<>();
    Random random = new Random();
    Lotnisko(int n){
        String x = "abcdefghijklmnoprstuwxyz";
        for (int i = 0; i < n; i++){
            NameGenerator nazwa = (y) -> {
                int p = random.nextInt(1 ,21);
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < p; k++){
                    str.append(y.charAt(random.nextInt(0,x.length())));
                }
                return str.toString();
            };
            int probability = random.nextInt(0,3);
            if (probability == 0){
                SamolotPasazerski samolotPasazerski = new SamolotPasazerski(nazwa.losuj(x), random.nextInt(500,1001), 0, random.nextInt(100,301), 0 );
                list.add(samolotPasazerski);
            } else if (probability == 1) {
                SamolotTowarowy samolotTowarowy = new SamolotTowarowy(nazwa.losuj(x), random.nextInt(300,701), 0, random.nextInt(10,101), 0 );
                list.add(samolotTowarowy);
            } else {
                Mysliwiec mysliwiec = new Mysliwiec(nazwa.losuj(x), random.nextInt(900,3001), 0 );
                list.add(mysliwiec);
            }
        }
    }
    public void OdprawaSamolotow() {

        for (Samolot samolot:list) {

            if (samolot instanceof SamolotPasazerski){
                ((SamolotPasazerski) samolot).setAkt_ilosc_pas(random.nextInt(0,400));
                try {
                    samolot.Odprawa();
                } catch (WyjatekLotniczy e) {
                    System.out.println(e.getMessage());
                }
            } else if (samolot instanceof SamolotTowarowy) {
                ((SamolotTowarowy) samolot).setAkt_ladunek(random.nextInt(0,201));
                try {
                    samolot.Odprawa();
                } catch (WyjatekLotniczy e) {
                    System.out.println(e.getMessage());
                }
            } else if (samolot instanceof Mysliwiec) {
                ((Mysliwiec) samolot).setIlosc_rakiet(random.nextInt(0,11));
                try {
                    samolot.Odprawa();
                } catch (WyjatekLotniczy e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public void dzialaniaLotniskowe(){
        Consumer<List<Samolot> > var = (list)-> {
            list.forEach(System.out::println);
            list.forEach(Samolot::laduj);
            list.forEach(samolot -> {
                        try {
                            samolot.Odprawa();
                        } catch (WyjatekLotniczy e) {
                            System.out.println(e.getMessage());
                        }
                    });
            list.forEach(a -> a.lec(10));
            list.forEach(samolot1 -> {if(samolot1 instanceof Mysliwiec) ((Mysliwiec) samolot1).Atak();


            });

        };
        var.accept(list);
    }
    public void sortowanieSamolotow(){
        Comparator<Samolot> cmp = Comparator.comparingInt(Samolot::getPredkosc_max);
        list.sort(cmp);
        System.out.println(list);
        Comparator<Samolot> tmp = Comparator.comparing(Samolot::getNazwa)
                .thenComparing(Samolot::getNazwa, Comparator.comparingInt(String::length));
        list.sort(tmp);
        System.out.println(list);
    }
    public void sortowanieLosowe(){
        SortowanieLosowe srt = () -> {
            int prob = random.nextInt(0,2);
            Comparator<Samolot> x;
            if (prob == 0){
                x =Comparator.comparing(Samolot::getPredkosc_max);
            } else {
                x = Comparator.comparing(Samolot::getNazwa)
                        .thenComparing(Samolot::getNazwa, Comparator.comparingInt(String::length));
            }
            list.sort(x);
            System.out.println(list);
        };
        srt.losowanie();

    }
    private static abstract class Samolot {
        private String nazwa;
        private int predkosc_max, ilosc_w_pow;
        private boolean leci = false;
        Samolot(String nazwa, int predkosc_max, int ilosc_w_pow){
            this.setNazwa(nazwa);
            this.setPredkosc_max(predkosc_max);
            this.setIlosc_w_pow(ilosc_w_pow);
        }


        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public void setIlosc_w_pow(int ilosc_w_pow) {
            this.ilosc_w_pow = ilosc_w_pow;
        }

        public void setPredkosc_max(int predkosc_max) {
            this.predkosc_max = predkosc_max;
        }
        public void lec(int ilosc_godzin){
            boolean z = true;
            try {
                this.Odprawa();
            } catch (WyjatekLotniczy e) {
                System.out.println("Problem z odprawa");
                System.out.println(e.getMessage());
                z = false;
            }
            if (z) {
                if (leci) {
                    System.out.println("Lecimy");
                    this.ilosc_w_pow += ilosc_godzin;
                } else {
                    System.out.println("Startujemy...");
                    this.ilosc_w_pow += ilosc_godzin;
                    this.leci = true;
                }
            }
        }
        public void laduj(){
            if (leci){
                this.leci = false;
                System.out.println("Ladujemy...");
            } else {
                System.out.println("I tak jestesmy na ziemi");
            }
        }
        public void Odprawa() throws WyjatekLotniczy{

        }
        public boolean getLeci(){
            return this.leci;
        }

        public int getPredkosc_max() {
            return predkosc_max;
        }

        public String getNazwa() {
            return nazwa;
        }

        @Override
        public String toString() {
            return " o nazwie: " + this.nazwa + ". Predkosc maksymalna: " + this.predkosc_max + ", w powietrzu spedzil laczne: " + this.ilosc_w_pow;
        }
    }
    private static class SamolotPasazerski extends Samolot {
        private int max_ilosc_pas, akt_ilosc_pas;

        SamolotPasazerski(String nazwa, int predkosc_max, int ilosc_w_pow, int max_ilosc_pas, int akt_ilosc_pas) {
            super(nazwa, predkosc_max, ilosc_w_pow);
            this.setAkt_ilosc_pas(akt_ilosc_pas);
            this.setMax_ilosc_pas(max_ilosc_pas);
        }

        @Override
        public void Odprawa() throws WyjatekEkonomiczny {
            if (akt_ilosc_pas < max_ilosc_pas / 2){
                throw new WyjatekEkonomiczny("Za mało pasazerow nie lecimy");

            } else if (akt_ilosc_pas > max_ilosc_pas) {
                throw  new WyjatekEkonomiczny("Przeladowano o " + (akt_ilosc_pas - max_ilosc_pas));
            }
        }


        public void setAkt_ilosc_pas(int akt_ilosc_pas) {
            this.akt_ilosc_pas = akt_ilosc_pas;
        }

        public void setMax_ilosc_pas(int max_ilosc_pas) {
            this.max_ilosc_pas = max_ilosc_pas;
        }

        @Override
        public String toString() {
            String str = "Samolot pasażerski" + super.toString() + " moze zabrac: " + this.max_ilosc_pas;
            if (this.getLeci()){
                return str + "Samolot leci z: " + this.akt_ilosc_pas + " pasazerami.";
            }
            return str + " uziemiony";
        }
    }
    private static class SamolotTowarowy extends Samolot {
        private int max_ladunek, akt_ladunek;
        SamolotTowarowy(String nazwa, int predkosc_max, int ilosc_w_pow, int max_ladunek, int akt_ladunek) {
            super(nazwa, predkosc_max, ilosc_w_pow);
            this.setAkt_ladunek(akt_ladunek);
            this.setMax_ladunek(max_ladunek);
        }

        @Override
        public void Odprawa() throws WyjatekEkonomiczny {
            if (akt_ladunek < max_ladunek / 2){
                throw new WyjatekEkonomiczny("Za mały ladunek nie lecimy");

            } else if (akt_ladunek > max_ladunek) {
                throw  new WyjatekEkonomiczny("Przeladowano o " + (akt_ladunek - max_ladunek) + " ton");
            }
        }

        public void setAkt_ladunek(int akt_ladunek) {
            this.akt_ladunek = akt_ladunek;
        }

        public void setMax_ladunek(int max_ladunek) {
            this.max_ladunek = max_ladunek;
        }
        @Override
        public String toString() {
            String str = "Samolot towarowy" + super.toString() + " moze zabrac: " + this.max_ladunek;
            if (this.getLeci()){
                return str + "Samolot leci z: " + this.akt_ladunek + " tonami ladunku";
            }
            return str + " uziemiony";
        }
    }
    private static class Mysliwiec extends Samolot {
        private int ilosc_rakiet;

        Mysliwiec(String nazwa, int predkosc_max, int ilosc_w_pow) {
            super(nazwa, predkosc_max, ilosc_w_pow);
            this.setIlosc_rakiet(ilosc_rakiet);
        }

        public void setIlosc_rakiet(int ilosc_rakiet) {
            this.ilosc_rakiet = ilosc_rakiet;
        }

        @Override
        public void Odprawa() {}
        public void Atak(){
            if (!this.getLeci()){
                return;
            } else if (this.ilosc_rakiet == 0) {
                this.laduj();
            } else {
                this.ilosc_rakiet--;
                System.out.println("Ataaaaak");
            }
        }
        @Override
        public String toString() {
            String str = "Samolot pasażerski" + super.toString();
            if (this.getLeci()){
                return str + "Samolot leci z: " + this.ilosc_rakiet + " rakietami na pokladzie";
            }
            return str + " uziemiony";
        }

    }
    @FunctionalInterface
    private interface SortowanieLosowe {
        void losowanie();
    }
    @FunctionalInterface
    private interface NameGenerator {
        String losuj(String var);
    }
    private static class WyjatekLotniczy extends Exception {
        WyjatekLotniczy(String msg){super(msg);}
    }
    public static class WyjatekEkonomiczny extends WyjatekLotniczy {

        WyjatekEkonomiczny(String msg) {
            super(msg);
        }
    }
}

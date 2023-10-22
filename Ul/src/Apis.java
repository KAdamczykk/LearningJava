import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apis {
    protected static List<Pszczola> ul = new ArrayList<>();

    public Apis(String imie_krolowej, int wiek_krolowej, int ilosc_jaj){
        ul.add(new Pszczola.KrolowaMatka(imie_krolowej, wiek_krolowej, 100, ilosc_jaj));
    }
    public void zyciePszczol(){
        Pszczola.KrolowaMatka krolowaMatka = (Pszczola.KrolowaMatka) ul.get(0);
        Pszczola.Truten t1 = new Apis.Pszczola.Truten("Gucio", 4,0);
        t1.zaplodnienie(krolowaMatka);
        Pszczola.Truten t2 = new Apis.Pszczola.Truten("Bacio", 2,0);
        t2.zaplodnienie(krolowaMatka);
        Random random = new Random();
        Pszczola.Robotnica r1 = new Apis.Pszczola.Robotnica("Marianna", 8,20);
        r1.zbierajNektar(random.nextInt(0,150));
        Pszczola.Robotnica r2 = new Apis.Pszczola.Robotnica("Andzelika", 12,40);
        r2.zbierajNektar(random.nextInt(0,150));
        Pszczola.Robotnica r3 = new Apis.Pszczola.Robotnica("Wioletta", 15,30);
        r3.zbierajNektar(random.nextInt(0,150));
        this.addPszczolka(t1);
        this.addPszczolka(t2);
        this.addPszczolka(r1);
        this.addPszczolka(r2);
        this.addPszczolka(r3);


    }
    public void addPszczolka(Pszczola pszczola){
        ul.add(pszczola);
    }
    public void watkiPszczol(){
        System.out.println("Watki Pszczol: ");
        for (Pszczola item : ul) {
            Thread thread = new Thread(item);
            thread.start();
        }
    }
    public Pszczola.KrolowaMatka findKrolowa(List<Pszczola> ul)throws NullPointerException{
        Pszczola.KrolowaMatka krolowa = null;
        for (Pszczola item:ul) {
            if (item instanceof Pszczola.KrolowaMatka){
                krolowa = (Pszczola.KrolowaMatka) item;
            }
        }
        return krolowa;
    }
    public void sortuj(){
        class Comparator implements java.util.Comparator<Pszczola> {
            @Override
            public int compare(Pszczola pszczola1, Pszczola pszczola2) {
                int wiekComparison = Integer.compare(pszczola2.getSilaAtaku(), pszczola1.getSilaAtaku());
                if (wiekComparison != 0) {
                    return wiekComparison;
                }
                return pszczola1.getImie().compareTo(pszczola2.getImie());
            }

        }
        java.util.Comparator<Pszczola> comparator = new Comparator();
        ul.sort(comparator);
    }
    public Pszczola dodajZolnieza(String imie, int wiek, int silaAtaku){
            return new Pszczola(imie, wiek, silaAtaku) {
            @Override
            public void run() {
                System.out.println("Walka to moje życie!!!");
            }

            @Override
            public String toString() {
                return "Zolnierz: " + " " + imie + " ( atak: " + silaAtaku + "), zyje: " +wiek + " dni " + " potrafie użądlić";
            }
        };

    }
    static abstract class Pszczola implements Runnable{
        private String  imie;
        private int wiek;
        protected int silaAtaku;
        public Pszczola(String imie, int wiek, int silaAtaku){
            this.imie = imie;
            this.wiek = wiek;
            this.silaAtaku = silaAtaku;
        }

        @Override
        public void run() {

        }
         static class KrolowaMatka extends Pszczola{
            private int ilosc_jaj;

             public KrolowaMatka(String imie, int wiek, int silaAtaku, int ilosc_jaj) {
                 super(imie, wiek, silaAtaku);
                 this.ilosc_jaj = ilosc_jaj;
                 this.silaAtaku = 100;
             }

             public void zaplodnienie(){
                this.ilosc_jaj += 1000;
            }

             @Override
             public void run() {
                 System.out.println("Lot godowy... ");
             }

             @Override
             public String toString() {
                 return "Krolowa Matka: " + super.toString() + "bede matka dla: " + this.ilosc_jaj + " pszczolek.";
             }
         }
        static class Truten extends Pszczola{
            private boolean przydatny;

            public Truten(String imie, int wiek, int silaAtaku) {
                super(imie, wiek, silaAtaku);
                this.przydatny = true;
                this.silaAtaku = 0;
            }

            public void zaplodnienie(KrolowaMatka krolowaMatka){
                if (przydatny) {
                    krolowaMatka.zaplodnienie();
                    this.przydatny = false;
                    System.out.println("Bylo i koniec");
                }
            }

            @Override
            public String toString() {
                if (!przydatny){
                    return "Truten: " + super.toString() + " nieprzydatny :((";
                }
                return "Truten: " + super.toString();
            }
            private KrolowaMatka findKrolowa(List<Pszczola> list){
                KrolowaMatka krolowaMatka = null;
                for (Pszczola element: list) {
                   if (element instanceof KrolowaMatka){
                       return krolowaMatka = (KrolowaMatka) element;
                   }
                }
                return krolowaMatka;
            }


            @Override
            public void run() {
                Random random = new Random();
                int probability = random.nextInt(0,2);
                if (probability == 0){
                    KrolowaMatka krolowaMatka = findKrolowa(ul);
                    if (krolowaMatka != null){
                        this.zaplodnienie(krolowaMatka);
                    }
                }
            }

        }
        static class Robotnica extends Pszczola{
            private int miodWyprodukowany;

            public Robotnica(String imie, int wiek, int silaAtaku) {
                super(imie, wiek, silaAtaku);
            }
            public void zbierajNektar(int nektar){
                this.miodWyprodukowany += nektar;
                System.out.print("Produkuje ");
            }

            @Override
            public void run(){
                Random random = new Random();
                int nektar = random.nextInt(0,21);
                this.zbierajNektar(nektar);
                System.out.println("Kolejny nektar");
            }

            @Override
            public String toString() {
                return "Robotnica: " + super.toString() + "zebralam: " + this.miodWyprodukowany + " barylek miodu :))";
            }
        }



        public String getImie() {
            return imie;
        }

        public int getSilaAtaku() {
            return silaAtaku;
        }

        @Override
        public String toString() {
            return this.imie + " ( atak: " + this.silaAtaku + "), zyje: " +this.wiek + " dni ";
        }


    }




}

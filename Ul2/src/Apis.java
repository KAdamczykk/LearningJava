import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Apis {
    private List<Pszczolka> ul = new ArrayList<>();
    Apis(String imie_krolowej, int wiek_krolowej, int ilosc_jaj){
        ul.add(new KrolowaMatka(imie_krolowej, wiek_krolowej,0, ilosc_jaj));
    }
    public void addPszczolka(Pszczolka pszczolka){
        this.ul.add(pszczolka);
    }
    public Pszczolka dodajZolnieza(String imie, int wiek, int silaAtaku){
        return new Pszczolka(imie, wiek, silaAtaku) {
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

    public List<Pszczolka> getUl() {
        return ul;
    }
    public void zyciePszczol(){
        KrolowaMatka krolowaMatka = (KrolowaMatka) ul.get(0);
        Truten t1 = new Truten("Gucio", 4,0);
        t1.Zaplodnienie(krolowaMatka);
        Truten t2 = new Truten("Bacio", 2,0);
        t2.Zaplodnienie(krolowaMatka);
        Random random = new Random();
        Robotnica r1 = new Robotnica("Marianna", 8,20);
        r1.zbierajNektar(random.nextInt(0,150));
        Robotnica r2 = new Robotnica("Andzelika", 12,40);
        r2.zbierajNektar(random.nextInt(0,150));
        Robotnica r3 = new Robotnica("Wioletta", 15,30);
        r3.zbierajNektar(random.nextInt(0,150));
        this.addPszczolka(t1);
        this.addPszczolka(t2);
        this.addPszczolka(r1);
        this.addPszczolka(r2);
        this.addPszczolka(r3);
    }
    public void watkiPszczol(){
        for (Pszczolka pszczolka:ul) {
            Thread thread = new Thread(pszczolka);
            thread.start();
        }
    }
    public void sortuj(){
        PorownanieSily porownanieSily = new PorownanieSily(){
            public int compare(Pszczolka pszczola1, Pszczolka pszczola2) {
                int wiekComparison = Integer.compare(pszczola2.getSilaAtaku(), pszczola1.getSilaAtaku());
                if (wiekComparison != 0) {
                    return wiekComparison;
                }
                return pszczola1.getImie().compareTo(pszczola2.getImie());
            }
        };
        this.ul.sort(porownanieSily);
    }

    public abstract class Pszczolka implements Runnable{
        private String imie;
        private int wiek;
        private int silaAtaku;
        Random random = new Random();
        Pszczolka(String imie, int wiek, int silaAtaku){
            this.setImie(imie);
            this.setWiek(wiek);
            this.setSilaAtaku(silaAtaku);
        }

        public int getSilaAtaku() {
            return silaAtaku;
        }

        public String getImie() {
            return imie;
        }

        public int getWiek() {
            return wiek;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public void setWiek(int wiek) {
            this.wiek = wiek;
        }

        public void setSilaAtaku(int silaAtaku) {
            this.silaAtaku = silaAtaku;
        }

        @Override
        public String toString() {
            return this.imie + " ( atak: " + this.silaAtaku + "), zyje: " +this.wiek + " dni ";
        }
    }
    public class KrolowaMatka extends Pszczolka{
        private int iloscJaj;
        KrolowaMatka(String imie, int wiek, int silaAtaku, int iloscJaj){
            super(imie, wiek, silaAtaku);
            this.setSilaAtaku(100);
            this.iloscJaj = iloscJaj;
        }
        public void Zaplodnienie(){
            this.iloscJaj += 1000;
        }

        @Override
        public void run() {
            System.out.println("Lot godowy...");
        }

        public int getIloscJaj() {
            return iloscJaj;
        }
        @Override
        public String toString() {
            return "Krolowa Matka: " + super.toString() + "bede matka dla: " + this.iloscJaj + " pszczolek.";
        }


    }
    public class Truten extends Pszczolka{
        private boolean przydatny;

        Truten(String imie, int wiek, int silaAtaku) {
            super(imie, wiek, silaAtaku);
            this.setSilaAtaku(0);
            this.przydatny = true;
        }
        public void Zaplodnienie(KrolowaMatka krolowaMatka){
            if (this.przydatny){
                krolowaMatka.Zaplodnienie();
                this.przydatny = false;
                System.out.println("Pora umierac");
            } else {
                System.out.println("Nieprzydatny");
            }
        }


        private KrolowaMatka findKrolowa(List<Pszczolka> list){
            KrolowaMatka krolowaMatka = null;
            for (Pszczolka element: list) {
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
                    this.Zaplodnienie(krolowaMatka);
                }
            }
        }
        @Override
        public String toString() {
            if (!przydatny){
                return "Truten: " + super.toString() + " nieprzydatny :((";
            }
            return "Truten: " + super.toString();
        }
    }
    public class Robotnica extends Pszczolka{
        private int wyprodukowanyMiod;

        Robotnica(String imie, int wiek, int silaAtaku) {
            super(imie, wiek, silaAtaku);
        }
        public void zbierajNektar(int miod){
            this.wyprodukowanyMiod += miod;
        }
        @Override
        public void run() {
            this.zbierajNektar(random.nextInt(0,21));
            System.out.println("Zbieram nektar");
        }

        public int getWyprodukowanyMiod() {
            return wyprodukowanyMiod;
        }
        @Override
        public String toString() {
            return "Robotnica: " + super.toString() + "zebralam: " + this.wyprodukowanyMiod + " barylek miodu :))";
        }
    }
    private class PorownanieSily implements Comparator<Pszczolka>{
        @Override
        public int compare(Pszczolka o1, Pszczolka o2) {
            return 0;
        }
    }
}

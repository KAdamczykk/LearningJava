package pl.edu.pw.po.roboty;

import pl.edu.pw.po.zasoby.Porozumienie;

import java.time.LocalDate;
import java.util.Random;

public abstract class Robot implements Porozumienie {
    int date;

    public enum lancuch {Adam1000, Roman2, Aleks900, Zosia_Samosia, Ala2, Robert01, Ula}
    private lancuch nazwa;
    String identyfikator = "";
    int ileZadan = 0;
    /**
     * jr
     * Brak klas, może niespushowane? (-2)
     * */
    SztucznaInteligencja.reprezentacja_danych si;
    /**
     * jr
     * Brak modyfikatorów (-0.5)
     * */
    String alfabet = "ABCDEFGHIJKLMNOPRSTUWXYZ";
    static int nr_fab = 0;
    /**
     * jr
     * nrFabryczny powinnien być final i brakuje pola statycznego do obsługi nrFabrycznego. (-0.5)
     * */
    int nrFabryczny;
    Robot(lancuch nazwa, SztucznaInteligencja.reprezentacja_danych si){
        this.setNazwa(nazwa);
        this.setYear();
        this.setSi(si);
        /**
         * jr
         * Dobrze, ale to powinna robić metoda pomocnicza.
         * */
        Random random = new Random();
        for (int i =0; i < 5; i++){
            int index = random.nextInt(0,alfabet.length());
            identyfikator = identyfikator + alfabet.charAt(index);
            }
        nrFabryczny = nr_fab;
        nr_fab ++;

        }


    @Override
    public String toString() {
        String var ="";
        if (this instanceof RobotProdukcja) {
            var ="RobotProdukcja";
        } else if (this instanceof RobotDomowy) {
            var = "RobotDomowy";
        } else if (this instanceof RobotSkladanie) {
            var = "RobotSkladanie";
        }
        return var + " o nazwie " +this.getNazwa() +" o identyfikatorze "+this.identyfikator + " i nr fabrycznym "+nrFabryczny+ " powstal w " +this.date + " sztuczna inteligencja " + this.getSi();
    }

    public void setNazwa(lancuch nazwa) {
        this.nazwa = nazwa;
    }
    public void setYear(){
        Random random1 = new Random();
        int rok = random1.nextInt(2000,2021);
        date = rok;

    }

    public lancuch getNazwa() {
        return nazwa;
    }

    public void setSi(SztucznaInteligencja.reprezentacja_danych si) {
        this.si = si;
    }

    public SztucznaInteligencja.reprezentacja_danych getSi() {
        return si;
    }

    @Override
    public int meldunek() {
        int rok = LocalDate.now().getYear();
        int roznica = rok - date;
        return roznica;
    }

    /**
     * jr
     * Nie tak, equals musi mieć określoną strukturę.
     * Musi wypełniać tzw kontrakt equals*/
    public static void Equal (Robot r1, Robot r2){
        if (r1.identyfikator == r2.identyfikator && r1.getClass() == r2.getClass() ){
            System.out.println("Takie same");
        } else {
            System.out.println("rozne");
        }
    }
}

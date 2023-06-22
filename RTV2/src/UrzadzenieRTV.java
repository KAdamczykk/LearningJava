import java.time.LocalDate;
import java.util.Random;

public class UrzadzenieRTV implements Odbieranie{
    Random random = new Random();
    LocalDate data_produkcji;

    int numerSeryjny;
    static int ilosc_Obiektow;
    String alfabet = "ABCDEFGHIJKLMNOPRSTUWXYZ";


    String nazwa;
    int ilosc_wlaczen;
    boolean wlaczone = false;
    public UrzadzenieRTV(){
        data_produkcji = LocalDate.now();
        numerSeryjny = ilosc_Obiektow;
        for (int i = 0; i <5; i++){
            int index =random.nextInt(0,alfabet.length());
            char x = alfabet.charAt(index);
            nazwa = nazwa + x;
        }
        String nr_ser =  ""+ numerSeryjny;
        nazwa = nazwa + nr_ser;
        final String nr = nazwa;
        ilosc_Obiektow++;
        setIlosc_wlaczen();


    }
    public void setIlosc_wlaczen(){
        int ilosc = random.nextInt(0,10);
        ilosc_wlaczen = ilosc;
    }

    public boolean isWlaczone() {
        return wlaczone;
    }

    @Override
    public String toString() {
        return this.getClass() + " o nazwie " + this.nazwa + " wyprodukowany w roku " + this.data_produkcji.getYear() + " ";
    }
    public void Wlacz(){
        Random ran = new Random();
        double probability = ran.nextDouble(0,1);
        if (probability < 0.1 || this.ilosc_wlaczen == 0){
            System.out.println("Urzadzenie zepsute");
        } else if (this.isWlaczone()){
            System.out.println("Urzadzenie juz wlaczone");
        } else {
            this.wlaczone = true;
            this.ilosc_wlaczen--;
            System.out.println("Wlaczono urzadzenie");
        }
    }
    public void Wylacz(){
        this.wlaczone = false;
        System.out.println("Urzadzenie wylaczone");
    }

    @Override
    public String Odbierz(Radio.czestotliwosc hz) {
        return null;
    }

    @Override
    public int Odbierz(int nr_kanalu) {
        return 0;
    }
}

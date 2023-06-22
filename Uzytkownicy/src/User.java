public class User {
    protected String imie;
    protected String nazwisko;
    protected int wiek;
    protected boolean zablokowane = false;


    public String toString() {
        return "Uzytkownik: " + this.imie + this.nazwisko + "\n"+"lat: " +this.wiek;
    }
    public boolean Sprawdz_wiek_uzytkownika(){
        if (this.wiek >= 18){
            boolean czy_starszy = true;
            return czy_starszy;
        } else {
            boolean czy_starszy = false;
            this.zablokowane = true;
            System.out.println("uzytkownik zablokowany");
            return czy_starszy;
        }
    }
    public void Blokuj(){
        this.zablokowane = true;
        System.out.println("uzytkownik zablokowany");
    }
    public boolean Czy_admin(){
        return false;
    }


}

public class Kosiarka {
    public static void czy_mam_Kosiarke(int ilosc_kosiarek, boolean pozyczyles_kosiarke, boolean sprawdziles_w_garazu, boolean totany_brak) throws UkradliKosiarkeException, StoiWGarazuZjebieException, PozyczonoKosiarkeDebiluException,BrakPrzedmiotuException{
        if (ilosc_kosiarek <=0){
            if (pozyczyles_kosiarke){
                throw new PozyczonoKosiarkeDebiluException("jest u sasiada");
            } else if (sprawdziles_w_garazu == true) {
                throw new StoiWGarazuZjebieException("w garazu jest");
            } else if (totany_brak) {
                throw new UkradliKosiarkeException("Ukradli");
            }
            else {
            throw new BrakPrzedmiotuException("gdzie jest kurwa moja kosiarka");}
        }
        else {
            System.out.println("badz spokojny");
        }
    }
    public static void main(String[] args) {
        int ilosc_kosiarek = 0;
        boolean totalnie = false;
        boolean pozycz = false;
        boolean garaz = true;
        try {
            Kosiarka.czy_mam_Kosiarke(ilosc_kosiarek,pozycz,garaz,totalnie);
        } catch (BrakPrzedmiotuException e) {
            System.out.println(e);
        }

    }
}

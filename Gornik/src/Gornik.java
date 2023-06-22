public class Gornik extends Adit{
    public Gornik(int max_dyst, int dlug_kor, int ilosc_kor) {
        super(max_dyst, dlug_kor, ilosc_kor);
    }
    static double income = 0;
    public double goMiner(Object[][] plansza){
        for (int i =0; i<ilosc_wierszy; i++){
            if (plansza[i][0] == "->"){
                for (int j = 1; j <= dlug_kor; j++){
                    if (plansza[i][j] instanceof Uraninit){
                        Uraninit uraninit = (Uraninit) plansza[i][j];
                        income = income + uraninit.getModifiedMarketValue();

                    } else if (plansza[i][j] instanceof Chalkolit) {
                        Chalkolit chalkolit = (Chalkolit) plansza[i][j];
                        income = income + chalkolit.getModifiedMarketValue();


                    }else {
                        Skala skala = (Skala) plansza[i][j];
                        income = income + skala.getModifiedMarketValue();

                    }
                    plansza[i][j] = null;
                }
            }
        }
        return income;
    }
}

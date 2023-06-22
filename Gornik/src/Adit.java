import java.util.Random;

public class Adit {
    int max_dyst;
    int dlug_kor;
    int ilosc_kor;
    int ilosc_wierszy;
    public Adit(int max_dyst, int dlug_kor, int ilosc_kor){
        this.max_dyst = max_dyst;
        this.dlug_kor = dlug_kor;
        this.ilosc_kor = ilosc_kor;
        ilosc_wierszy = (this.max_dyst + 1 ) * this.ilosc_kor;
    }

    public Object[][] uzupelnijPlansze(){
        Object[][] Plansza =new Object[this.ilosc_wierszy][this.dlug_kor + 1];
        Random random = new Random();
        int index_wiersza = 0;
        int puste;
        for(int i = 0; i<this.ilosc_kor; i++){
            puste = random.nextInt(0,4);
            index_wiersza = index_wiersza + puste + 1;
            Plansza[index_wiersza][0] = "->";}


        Random ran = new Random();
        for (int i = 0; i < ilosc_wierszy; i++){
             if (Plansza[i][0] == "->"){
                    for (int j = 1; j <= this.dlug_kor; j++){
                        double los = ran.nextDouble(0,1);
                        if (los < 0.1){
                            Random r = new Random();
                            int index = r.nextInt(0,2);
                            Uraninit uraninit = new Uraninit(50, index);
                            Plansza[i][j] = uraninit;
                        } else if (los < 0.3 && los > 0.1) {
                            Chalkolit chalkolit = new Chalkolit(50);
                            Plansza[i][j] = chalkolit;

                        } else {
                            Skala skala = new Skala();
                            Plansza[i][j] = skala;
                        }
                    }
            }
        }
        return Plansza;
        }
    public final String WypiszPlonsze(Object[][] Plansza){
        String str = "";
        for (int i =0; i < this.ilosc_wierszy; i++){
            if (Plansza[i][0] == "->"){
                str = str + "->  ";
                for (int j = 1; j <=this.dlug_kor; j++){
                    if (Plansza[i][j] instanceof Uraninit){
                        str = str + "U50 ";
                    } else if (Plansza[i][j] instanceof Chalkolit) {
                        str = str + "C50 ";

                    } else{
                        str = str+ "*** ";
                    }
                }

            } else {
                str = str + "    ";
                for (int j = 1; j <=this.dlug_kor; j++){
                    str = str + "### ";
                }
            }
            str = str +"\n";
        }
        return str;
    }

}

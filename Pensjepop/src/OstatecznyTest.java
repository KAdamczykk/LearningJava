import java.util.Scanner;

public class OstatecznyTest implements Runnable{
    Scanner scanner = new Scanner(System.in);
    int n;
    int[] stopien;
    int[] pensja;
    int[] przelozony;
    int[] podwladny;
    int[] uzyte;
    int[] kolejka;
    int[] ile_podwladnych;
    int pocz = 0, kon = 0;
    public void zaczytaj(){
        n = scanner.nextInt();
        scanner.nextLine();
        stopien = new int[n+2];
        przelozony = new int[n+2];
        podwladny = new int[n+2];
        uzyte = new int[n+2];
        kolejka = new int[n+2];
        pensja =  new int[n+2];
        ile_podwladnych = new int[n+2];
        for (int i = 1; i <= n ; ++i){
            przelozony[i] = scanner.nextInt();
            pensja[i] = scanner.nextInt();
            if (przelozony[i] == i){
                pensja[i] = n;
            }
            if (pensja[i] != 0) {
                przelozony[i] = n + 1;
            }
            scanner.nextLine();
        }
        ++n;
        pensja[n] = n;
        przelozony[n] = n;
    }
    public void znajdzpodlawdnych(){
        for (int i = 1; i < n; ++i){
            stopien[i] = 0;
        }
        for (int  i = 1; i <n; ++i){
            ++stopien[przelozony[i]];
        }
        for (int i = 1; i < n; ++i){
            if (stopien[i] == 0){
                kolejka[kon++] = i;
            }
        }
        while (pocz < kon){
            int akt = kolejka[pocz++];
            int przel = przelozony[akt];
            if (pensja[akt] == 0){
                if (--stopien[przel] == 0){
                    kolejka[kon++] = przel;
                }
                ile_podwladnych[przel] += ile_podwladnych[akt] + 1;
            }
        }
    }
    public void oznacz_uzyte_pensje(){
        for (int  i = 0; i < n; ++i){
            if (pensja[i] != 0){
                uzyte[pensja[i]] = i;
            } else if (podwladny[przelozony[i]] == 0) {
                podwladny[przelozony[i]] = i;
            } else {
                podwladny[przelozony[i]] = -1;
            }
        }
    }
    public void uzupelnijPensje(){
        int wolne = 0, mozliwe = 0, i = 0;
        while (i < n - 1){
            while (i < n - 1 && uzyte[i+1] == 0){
                i++;
                wolne++;
                mozliwe++;
            }
            while (i < n - 1 && uzyte[i+1] != 0){
                i++;
                int akt = uzyte[i], l = i;
                wolne -= ile_podwladnych[akt];
                if (wolne == 0){
                    while (mozliwe-- > 0 && podwladny[akt] > 0){
                        while (uzyte[l] != 0){
                            l--;
                        }
                        akt = podwladny[akt];
                        pensja[akt] = l;
                        uzyte[l] = akt;
                    }
                    mozliwe = 0;
                }
                if (ile_podwladnych[akt] != 0){
                    mozliwe = 0;
                }
            }
        }
    }
    public void wypisz(){
        for (int i = 1; i < n; ++i) {
            System.out.println(pensja[i]);
        }
    }
    @Override
    public void run() {
        this.zaczytaj();
        this.znajdzpodlawdnych();
        this.oznacz_uzyte_pensje();
        this.uzupelnijPensje();
        this.wypisz();
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new OstatecznyTest());
        thread.start();
    }


}

import java.util.Scanner;

public class Pensje {

    public static void main(String[] args) {
        // implementacja przykladu z ksiazeczki w javie, probowałem robic tez innymi sposobami, ale zawsze 1/4 testow sie przewracala
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // pobieramy liczbe pracownikow
        int[] przelozony = new int[n + 2]; // tworzymy tablice z przelozonymi, pensjami, pensjami uzytymi, ilosciom podwladnych, koleka
        int[] pensja = new int[n + 2];
        int[] uzyte = new int[n + 2];
        int[] ile_podwladnych = new int[n + 2];
        int[] stopien = new int[n + 2];
        int[] podwladny = new int[n + 2];
        int[] kolejka = new int[n + 2];
        int pocz = 0, kon = 0;

        for (int i = 1; i <= n; ++i) { // zaczytujemy dane za standardowego wejcia
            przelozony[i] = scanner.nextInt();
            pensja[i] = scanner.nextInt();
            if (przelozony[i] == i) {
                pensja[i] = n;
            }
            if (pensja[i] != 0) {
                przelozony[i] = n+1;
            }
        }

        ++n;
        przelozony[n] = n;
        pensja[n] = n;

        policz_podwladnych(n, przelozony, pensja, stopien, kolejka, pocz, kon, ile_podwladnych);
        oznacz_uzyte_pensje(n, przelozony, pensja, podwladny, uzyte);

        int i = 0;
        int ile_wolnych = 0, ile_mozliwych = 0;
        while (i < n - 1) { // Pętla główna przechodząca przez pracowników, pomijając ostatniego.
            while (i < n - 1 && uzyte[i + 1] == 0) { // Wewnętrzna pętla, która przesuwa się do przodu, zliczając wolne i możliwe pensje.
                ++i;
                ++ile_wolnych;
                ++ile_mozliwych;
            }
            while (i < n - 1 && uzyte[i + 1] != 0) { //  Druga wewnętrzna pętla, przetwarzająca pracowników z zajętymi pensjami.
                ++i; //  Przesunięcie do kolejnego pracownika z zajętą pensją
                int akt = uzyte[i], l = i; //  Aktualny pracownik i indeks
                ile_wolnych -= ile_podwladnych[akt]; // Aktualizacja ilości wolnych pensji, odejmując liczbę podwładnych pracownika.
                if (ile_wolnych == 0) { // Początek bloku kodu wykonywanego, gdy brak wolnych pensji
                    while (ile_mozliwych-- > 0 && podwladny[akt] > 0) { // Pętla przypisująca pensje pracownikom z kolejki możliwych pensji.
                        while (uzyte[l] != 0) { // Znalezienie najniższego dostępnego indeksu pensji
                            --l;
                        }
                        akt = podwladny[akt]; //  Przesunięcie do bezpośredniego podwładnego.
                        pensja[akt] = l; // Przypisanie pensji pracownikowi
                        uzyte[l] = akt; // Oznaczenie pensji jako użytej
                    }
                    ile_mozliwych = 0; // Zresetowanie licznika możliwych pensji
                }
                if (ile_podwladnych[akt] != 0) { // Resetowanie licznika możliwych pensji, jeśli pracownik ma podwładnych.
                    ile_mozliwych = 0;
                }
            }
        }
        for (int j = 1; j < n; ++j) {
            System.out.println(pensja[j]);
        }
    }

    public static void policz_podwladnych(int n, int[] przelozony, int[] pensja, int[] stopien, int[] kolejka, int pocz, int kon, int[] ile_podwladnych) {
        // liczymy ilosc podwładnych dla kazdego pracownika
        for (int i = 1; i < n; ++i) {
            stopien[i] = 0;
        }
        for (int i = 1; i < n; ++i) {
            ++stopien[przelozony[i]];
        }
        for (int i = 1; i < n; ++i) {
            if (stopien[i] == 0) {
                kolejka[kon++] = i;
            }
        }
        while (pocz < kon) {
            int akt = kolejka[pocz++];
            int przel = przelozony[akt];
            if (pensja[akt] == 0) {
                if (--stopien[przel] == 0) {
                    kolejka[kon++] = przel;
                }
                ile_podwladnych[przel] += ile_podwladnych[akt] + 1;
            }
        }
    }

    public static void oznacz_uzyte_pensje(int n, int[] przelozony, int[] pensja, int[] podwladny, int[] uzyte) {
        // oznaczamy ktore pensje sa juz w uzyciu
        for (int i = 1; i < n; ++i) {
            if (pensja[i] != 0) {
                uzyte[pensja[i]] = i;
            } else if (podwladny[przelozony[i]] == 0) {
                podwladny[przelozony[i]] = i;
            } else {
                podwladny[przelozony[i]] = -1;
            }
        }
    }
}



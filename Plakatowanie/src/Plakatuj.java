import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plakatuj implements Runnable{
    // liczę plakaty na podstawie stosu, gdyz w poczatkowej wersji chciałem to robic zupelnie inaczej i mimo dobrych wynikow, zlozonosc O(n^2)
    // sprawiała ze kod potrafil wykonywac sie dlugo dla duzych danych. Stad uzylem rowniez implementacji stosu, ktora zostala rowniez opisana w ksiazeczce
    List<Budynek> lista_budynkow = new ArrayList<>();
    int ilosc_budynkow;
    File plik;
    Scanner scanner;
    Plakatuj(File plik){
        this.plik = plik;
        zaczytaj();
    }
    Plakatuj(){
        zaczytajZestandardowegoWejsca();
    }
    public void zaczytaj(){
        // zaczytanie danych o zadanej strukturze z pliku zrodlowego
        try {
            scanner = new Scanner(plik);
            this.ilosc_budynkow = scanner.nextInt(); // 1 linijka to ilosc budynkow
            scanner.nextLine();
            for (int i = 0; i < ilosc_budynkow; i++) {
                String[] linia = scanner.nextLine().split(" ");
                int szerokosc = Integer.parseInt(linia[0]);
                int wysokosc = Integer.parseInt(linia[1]);
                lista_budynkow.add(new Budynek(szerokosc, wysokosc)); // tworzymy budynki o zadanej szerokosci i wysokosci
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void zaczytajZestandardowegoWejsca(){
        // gdy nie chcemy z pliku tworzyc
        scanner = new Scanner(System.in);
        System.out.println("Podaj dane");
        ilosc_budynkow = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < ilosc_budynkow; i++){
            int szerokosc = scanner.nextInt();
            int wysokosc = scanner.nextInt();
            Budynek budynek = new Budynek(szerokosc, wysokosc);
            lista_budynkow.add(budynek);
            scanner.nextLine();
        }

    }
    public void zapisz(int result){
        // zapisywanie wyniku do pliku o tej samej nazwie i o zmianie rozszerzenia na .out
        File file = new File(plik.getPath().substring(0,plik.getPath().lastIndexOf(".")) + ".out");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(result);
            bufferedWriter.close();
            System.out.println("Zapisano"); // informacja na standardowe wyjscie
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int minIloscPlakatow(){
        // obliczanie minimalnej ilosci plakatow na podstawie implementacji stosu O(n)
        int stos_size = 0; // ilosc elementow w stosie
        int minimum = 0; // result
        Budynek[] stos = new Budynek[ilosc_budynkow]; // tworzymy stos jako tablice o dlugosci rownej ilosci budynkow
        for (Budynek budynek:lista_budynkow) { // iteracja po wszystkich budynkach
            int wysokosc = budynek.wysokosc;
            while (stos_size > 0 && stos[stos_size - 1].wysokosc > wysokosc){ // jesli ilosc elementow na stosie jest wieksza od 0 i ostatni element na stosie ma wieksza wysosoksc niz nasz budynek to zdejmujemy go ze stosu i zwiekszamy liczbe plakatow i tak do przerwania petli
                minimum++;
                stos_size--;
            }
            if (stos_size == 0 || stos[stos_size -1].wysokosc < wysokosc){ // w przeciwnym przypadku dodajemy do stosu budynek i zwiekszamy rozmiar stosu
                stos[stos_size] = budynek;
                stos_size++;
            }
        }
        minimum += stos_size; // do wyniku dodajemy jeszcze elementy ktore sa na stosie bo je trzeba pokryc rowniez plakatami
        return minimum;
    }

    @Override
    public void run() {
        // w watku przeprowadzam metode minIloscPlakatow(), i wypisuje na konsole wynik, ktory jest rowniez zapiywany do pliku
        int result = minIloscPlakatow();
        System.out.println("Min ilosc plakatow: " + result);
        zapisz(result);

    }


    public static class Budynek{
        private int szerokosc, wysokosc;
        Budynek(int szerokosc, int wysokosc){
            this.szerokosc = szerokosc;
            this.wysokosc = wysokosc;
        }

    }

    public static void main(String[] args) {
        File file = new File("in/pla10b.in"); // czytamy plik
        Plakatuj plakatuj = new Plakatuj(file); // tworzymy obiekt plakatuj
        Thread thread = new Thread(plakatuj); // tworzymy watek
        long startTime = System.currentTimeMillis(); // chcemy rowniez obliczyc czas wykonywania metod w watku, wiec uzywamy start i join i mierzymy czas wykonywania
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        double executionTime = (endTime - startTime)/1000.0;
        System.out.println("Wykonano w czasie: " + executionTime); // zwracamy informacje rowniez o czasie wykonywania
        Plakatuj plakatuj1 = new Plakatuj(); // opcja z czytaniem ze standardowego wejscia a nie z pliku
        System.out.println(plakatuj1.minIloscPlakatow());
    }


}

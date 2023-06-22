import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    private static Logger logger = Logger.getLogger("Main"); //logger ladnie wypisuje bledy na konsole
    static void logException(Exception e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());}
    public static void main(String[] args) {
        //wyjatki
        //Error i RuntimeException - nieobslugujemy
        // RunTimeException - blad programistyczny
        // try -> wrzycamy instrukcje ktora moze powodowac blad
        // catch(klasa wyjatku e) { postepowanie w razie wyjatku }
        // finally -> wykona sie niezaleznie od tego czy bedzie wyjatek czy nie
        // zasada: zaczynamy od bardziej szczegolowych a konczymy na ogolnych
        // przyklad try catch
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj index ");
        int index = scanner.nextInt();
        int[] list = new int[5];
        for (int i =0; i< list.length; i++){
            list[i] = i;
        }

        try {
            list[index] = 100;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Przektoczony zakres tablicy, wyjatek: " +e);
            logException(e);
        } finally {
            list[3] = 200;
            for (int i =0; i< list.length; i++){
                System.out.print(list[i] +" ");
            }
        }
        System.out.println();
        System.out.println(list[2]); //still program sie wykonuje

        //wlasne wyjatki
        //throw -> wyrzuca nasz wyjatek
        try{
            if (index >= list.length){
            throw new StupidException("glupi blad");
            }
        } catch (StupidException e) {
            System.out.println("zrobiles " + e.getMessage());
            logException(e);
        }

        // throws, informowanie o wyjatkach
        // przetestujmy
        Dzielenie dzielenie = null;
        try {
            dzielenie = new Dzielenie();
        } catch (StupidException e) {
            System.out.println("znowu " +e);
            logException(e);
        }
        System.out.println("Podaj liczbe do dzielnia ");
        int x = scanner.nextInt();
        System.out.println("Podaj liczbe przez ktora dzielisz ");
        int y = scanner.nextInt();
        try {
            dzielenie.Podziel(x,y);
        } catch (ArithmeticException  | StupidException | NullPointerException e) {
            System.out.println("wykryto blad " +e);
            logException(e);
        }
        // wyjatki sie wywoluja wzgledem kolejnosci wywolania w kodzie nie po hierarchi
    }
}
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task2 implements Serializable {
    static JFileChooser fileChooser = new JFileChooser();
    public static class Wynik implements Comparable<Wynik>, Serializable{
        protected static int counter = 0;
        protected String imie;
        protected int pokonane;
        protected int time;
        protected transient int id;
        public Wynik(String imie, int pokonane, int time){
            this.id = counter;
            this.pokonane = pokonane;
            this.imie = imie;
            this.time = time;
            counter++;
        }

        @Override
        public String toString() {
            return "Id: " + this.id + " imie: " + this.imie + " pokonani: " + this.pokonane + " time: " + this.time +" ";
        }


        @Override
        public int compareTo(Wynik o) {
            if (this.time < o.time){
                return -1;
            } else if (this.time == o.time) {
                return 0;
            }
            return 1;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor = -1;
        List<Wynik> lista = null;
        do {
            System.out.println("Wybierz opcje");
            System.out.println("1. Tworz liste");
            System.out.println("2. Zapisz liste");
            System.out.println("3. Wczytaj liste");
            System.out.println("4. Wypisz liste");
            System.out.println("0. Zakoncz");
            wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor){
                case 0:
                    break;
                case 1:
                    lista = createList();
                    break;
                case 2:
                    saveFile(lista);
                    break;

                case 3:
                    lista = openFile();
                    break;
                case 4:
                    System.out.println(lista);
                    break;
            }
        } while (wybor != 0);


    }
    protected static List<Wynik> createList(){
        String[] imiona = {"Jan", "Marcin", "Edyta", "Zuzia", "Jacek", "Roman", "Adam", "Jaroslaw", "Julia", "Joanna"};
        Random random = new Random();
        List<Wynik> lista = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            String imie = imiona[random.nextInt(0, imiona.length)];
            int pokonane = random.nextInt(0,1000);
            int time = random.nextInt(360, 30000);
            lista.add(new Wynik(imie, pokonane, time));
        }
        lista.sort(Wynik::compareTo);
        return lista;
    }
    protected static void saveFile(List<Wynik> lista){
        File plik = null;
        fileChooser.showSaveDialog(null);
        plik = fileChooser.getSelectedFile();

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(plik));
            out.writeObject(lista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static List<Wynik> openFile(){
        List<Wynik> lista = null;
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            lista = (List<Wynik>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

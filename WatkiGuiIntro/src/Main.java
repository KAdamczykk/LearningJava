import java.time.Instant;
import java.time.temporal.ChronoUnit;


//uruchomic watek, sleep i join
public class Main {
    public static void main(String[] args) throws InterruptedException { // to albo try catch
        // WĄTKI
        // dziedzicza po Thread lub implementacja Runnable
        // uzywa sie ich zeby wykonac kilka rzeczy w tym ssamym momencie

        // inicjaca watkow

        Obliczenia o1 = new Obliczenia(15000000);
        Obliczenia o2 = new Obliczenia(1000656565);

        // tworzymy nowe watki do obiektow
        Thread t1 = new Thread(o1);
        Thread t2 = new Thread(o2);

        Instant c1 = Instant.now(); // mierzenie czasu
        t1.start(); // nie wywolujemy metody run tylko samo start zeby byla wielowatkowosc
        t2.start();
        t1.join(); // join sluzy do blokowania wykonywania biezacego watku dopoki nie skonczy sie watek na ktorym to uzywamy
        Instant c2 = Instant.now();

        System.out.println("Wynik " + o1.getWynik());
        long czas = ChronoUnit.MILLIS.between(c1,c2);
        System.out.println("Czas " +  czas);

        // sleep - zatrzymuje wykonane watku na dany okres czasu w ms, zeby iine sie wykonaly


        // Zdarzenia
        // ActionListener - najbardziej ogolny
        // MouseListener - co klikniete na myszy
        // MouseMotionListener - poruszanie sie myszy
        // KeyListener - przycisk klawiatury
        // AdjustmentListener - zmiana stanu skladnik np przesuniecie suwaka
        // WindowListener - zmiana stau okna
        // imlementacja -> nowa instancja -> addCoslistener

        // GUI
        // Najpierw JFrame/Jdialog/Japplet i dalej na to nakladamy rzeczy
        // na Jframe nakladamy JLabale, ktore moga zawierac pola tekstowe itd
        // JPanel moze przetrzymywac kilka JLabeli
        // Jframe -> JPanel -> JLabel
        // JPanel : setLayout(null), setBackground(), add(label), setHorizontal itd ; frame.add(panel)
        // Buttons


    }

}
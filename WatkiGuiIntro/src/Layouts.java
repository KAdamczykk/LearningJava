import javax.swing.*;
import java.awt.*;

public class Layouts {
    public static class MyFrame extends JFrame{
        public MyFrame(LayoutManager layoutStyle){
            this.setSize(500,500);
            this.setLayout(layoutStyle);
            this.setTitle("Example");
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

    }

    public static void main(String[] args) {
        /*MyFrame frame = new MyFrame(new BorderLayout()); // dajac w new BorderLayout(liczba1, liczba2) robimy pixelowe odstepy o dlugosci wart. podanej w liczbie, (lewo-prawo, gora-dol)
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.GRAY);
        panel3.setBackground(Color.GREEN);
        panel4.setBackground(Color.YELLOW);
        panel5.setBackground(Color.RED);

        panel1.setPreferredSize(new Dimension(100,50));
        panel2.setPreferredSize(new Dimension(50,100));
        panel3.setPreferredSize(new Dimension(50,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,50));

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.CENTER);
        frame.add(panel5, BorderLayout.SOUTH); */

        // na kazdym z paneli mozemy wywolac rowniez BorderLayout i podzielic go na kolejne
        // FlowLayout - dziala tak samo ale ustawia wszystko w rzedzie
        MyFrame frame2 = new MyFrame(new FlowLayout(FlowLayout.CENTER, 10,5)); // Wysrodkowanie, wysokos od gory okna, odleglosc miedzy kompoentami
        JPanel panel = new JPanel();
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.setPreferredSize(new Dimension(300,50));
        frame2.add(panel);

        // GridLayout (ilosc wierszy, ilosc kolumn, odleglosci: gora, boki)
        // JLayredPane - mozliwosc ustaiania labeli 3D, ze nachodza na siebie odpowiednik JPanel
        // dodajac do Layred Pane mozemy po przecinku wyierac opcje dodania na duzo sposobow


    }
}

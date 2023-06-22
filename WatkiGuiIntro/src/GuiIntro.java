import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiIntro {
    public static class GUIZabawa{
        private int sizeX, sizeY;
        private JFrame frame = new JFrame();
        private String title;
        private ImageIcon icon;
        private Border border = BorderFactory.createLineBorder(Color.green, 3);
        public GUIZabawa(int sizeX, int sizeY, String title, ImageIcon icon){
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.title = title;
            this.icon = icon;
            this.makeFrame();
        }
        private void makeFrame(){
            frame.setSize(sizeX, sizeY);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle(title);
            frame.setIconImage(icon.getImage()); //idk czemu nie dziala
            //frame.setResizable(false); // nie zmieniaj szerokosci okna
            frame.setVisible(true);
            frame.setLayout(null);
           // frame.getContentPane().setBackground(Color.BLACK); // zmiana tla JFrame // new Color(kordy,kordy,kordy) - tworzy nowy kolor

        }
        public void makeLabel(){
            JPanel panel = new JPanel();
            panel.setBounds(0,0,400,400);
            panel.setBorder(border);

            JLabel label = new JLabel();
            label.setText("To jest moje bagno");
            label.setIcon(icon);
            label.setVerticalTextPosition(JLabel.TOP); // tekst gora dol srodek w odniesieniu do image
            label.setHorizontalTextPosition(JLabel.CENTER); // tekst lewo prawo srodek same
            label.setForeground(Color.red); // kolor czcionki- setFont - typ czcionki
            label.setIconTextGap(10); // odleglosc tektu od icon
            label.setBackground(Color.black);
            label.setOpaque(true); // zmiana tla
            label.setVerticalAlignment(JLabel.TOP); // caly label jak ustawic
            // label.setBounds(kordy) - gdzie ma byc ustawiony label w frame po kordach
            // label.setBorder(border);
            panel.add(label);
            frame.add(panel);
            //frame.pack(); // dostosuj wielkosc do labela
         //   frame.setResizable(false);
            // tez mozna robic setVisible np w if cos
        }
        public void addButton(){
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0,400,300,100);
            panel.setBorder(border);
            JButton button = new JButton();
            button.setSize(200,50);

            button.addActionListener(e -> System.out.println("Chuj")); // lambda
            button.setText("Nie masz psychy kliknac");
            button.setFocusable(false);
            // te same settery prawie co w label

            panel.add(button);
            frame.add(panel);
        }


    }

    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("D:/Studia/Semestr 2/Java/WatkiGuiIntro/src/shrekk.jpg");
        GUIZabawa frame = new GUIZabawa(700,700,"ExampeGui", image);
        frame.addButton();
        frame.makeLabel();
    }
}

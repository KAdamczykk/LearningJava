import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mysz {
    public static class Myszunia extends JFrame implements MouseListener {
        JLabel label;
        Myszunia(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500,500);
            this.setLayout(null);
            this.setVisible(true);
            label = new JLabel();
            label.setSize(150,150);
            label.setBackground(Color.red);
            label.setOpaque(true);
            label.addMouseListener(this);
            this.add(label);
        }

        @Override
        public void mouseClicked(MouseEvent e) { //wcisniesz i puscisz
            label.setBackground(Color.yellow);
        }

        @Override
        public void mousePressed(MouseEvent e) { // zostanie wcisniety
            label.setBackground(Color.blue);
        }

        @Override
        public void mouseReleased(MouseEvent e) { // puszczona mysz
            label.setBackground(Color.orange);
        }

        @Override
        public void mouseEntered(MouseEvent e) { // wejdzie na teren komponentu
            label.setBackground(Color.black);
        }

        @Override
        public void mouseExited(MouseEvent e) { // opusci teren komponentu
            label.setBackground(Color.gray);
        }
    }

    public static void main(String[] args) {
        new Myszunia();

    }
}

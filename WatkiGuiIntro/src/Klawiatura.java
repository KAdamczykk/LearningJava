import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klawiatura {
    public static class Rameczka extends JFrame implements KeyListener {
        JLabel label;
        public Rameczka(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500,500);
            this.setLayout(null);
            this.addKeyListener(this);
            this.setVisible(true);
            label = new JLabel();
            label.setBounds(0,0,150,150);
            label.setBackground(Color.blue);
            label.setOpaque(true);
            this.add(label);

        }
        // getKeyChar - litera
        // getKeyCode - nr przycisku
        @Override
        public void keyTyped(KeyEvent e) { // wcisniety i zwolniony - tylko znaki

        }

        @Override
        public void keyPressed(KeyEvent e) { //wcisniecie
            int klyk = e.getKeyChar();
            switch (klyk){
                case 'a': label.setLocation(label.getX()-10, label.getY());
                    break;
                case 'w': label.setLocation(label.getX(), label.getY()-10);
                    break;
                case 'd': label.setLocation(label.getX()+10, label.getY());
                    break;
                case 's': label.setLocation(label.getX(), label.getY()+10);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) { // puszczenie

        }
    }

    public static void main(String[] args) {
        new Rameczka();
    }
}

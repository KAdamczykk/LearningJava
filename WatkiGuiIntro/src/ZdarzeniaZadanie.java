import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZdarzeniaZadanie {
    public static class Okno extends JFrame{
        private int x,y;
        private static int Myszcounter, Keycounter;
        JTextField textField;
        JPanel panel;


        public Okno(){

            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500,500);
            this.setLocation(300,150);
            panel= new JPanel();
            textField = new JTextField();
            panel.setSize(300,300);
            textField.setPreferredSize(new Dimension(100,100));
            textField.setBackground(Color.lightGray);
            textField.setOpaque(true);
            ObslugaMyszy om = new ObslugaMyszy(this);
            textField.addKeyListener(new ObslugaKlawiatury(this));
            textField.addMouseListener(om);
            textField.addMouseMotionListener(om);
            panel.setLocation(100,100);
            panel.add(textField);
            this.add(panel);
            this.addMouseListener(om);
            this.addMouseMotionListener(om);
            this.setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            try {
                if (Myszcounter >10 || Keycounter > 10){
                    throw new WyjatekSumaKlikniec("Zerowanie");
                }

            } catch (WyjatekSumaKlikniec e){
                Myszcounter = 0;
                Keycounter = 0;
                System.out.println(e.getMessage());
            } finally {
                g.drawString("Wspolrzedne myszy x: " +x+ " y: " +y, 10,40);
                g.drawString("Klikniecia myszy: " + Myszcounter, 10,50 );
                g.drawString("Klikniecia klawiatury: " +Keycounter, 10,60);
            }

        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    public static class ObslugaMyszy implements MouseListener, MouseMotionListener {
        private Okno okno;
        public ObslugaMyszy(Okno okno){
            this.okno = okno;

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Okno.Myszcounter++;
            okno.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            okno.setX(e.getX());
            okno.setY(e.getY());
            okno.repaint();
        }
    }
    public static class ObslugaKlawiatury implements KeyListener{
        private Okno okno;
        public ObslugaKlawiatury(Okno okno){
            this.okno = okno;
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            Okno.Keycounter++;
            okno.repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    public static class WyjatekSumaKlikniec extends Exception{
        private String msg;
        public WyjatekSumaKlikniec(){}
        public WyjatekSumaKlikniec(String msg){super(msg);}
    }

    public static void main(String[] args) {
        new Okno();
    }
}

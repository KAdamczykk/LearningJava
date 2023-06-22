package mini;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    ImageIcon icon = new ImageIcon("C://Users//Darek//Downloads//shrek.jpg");
    private String tekst= "";
    private int x;
    private int y;
    private int[][] punkty = new int[2][1000000];
    private int ilosc_punktow;
    private Color color;

    Okno(){
        this.setSize(400,400);
        this.setTitle("Myszz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(icon.getImage());
        this.setLocation(400,300);
        ObslugaMyszy om = new ObslugaMyszy(this);
        ObslugaKlawiatury ok = new ObslugaKlawiatury(this);
        addMouseListener(om);
        addMouseMotionListener(om);
        addKeyListener(ok);
        // okno my sie raz rysowalo trzeba zminimalizowac i przerysuje sie +okno.repaint w Obsludze myszy


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(tekst, x,y);
        g.setColor(color);
        g.drawPolyline(punkty[0], punkty[1], ilosc_punktow);


    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }



    public void addPunkt(int x, int y) {
        punkty[0][ilosc_punktow] = x;
        punkty[1][ilosc_punktow] = y;
        ilosc_punktow++;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void main(String[] args) {
        new Okno();

    }

}

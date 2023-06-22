package mini;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ObslugaKlawiatury implements KeyListener {
    private Okno okno;
    ObslugaKlawiatury(Okno okno){this.okno=okno;}
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char przycisk = e.getKeyChar();
        switch (przycisk) {
            case 'r' -> okno.setColor(Color.red);
            case 'w' -> okno.setColor(Color.white);
            case 'y' -> okno.setColor(Color.yellow);
            case 'o' -> okno.setColor(Color.orange);
            case 'g' -> okno.setColor(Color.gray);
            case 'l' -> okno.setColor(Color.green);
            case 'm' -> okno.setColor(Color.magenta);
            case 'p' -> okno.setColor(Color.pink);
            default -> okno.setColor(Color.black);
        }




        okno.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

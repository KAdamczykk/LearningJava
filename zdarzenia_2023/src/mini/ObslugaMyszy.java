package mini;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ObslugaMyszy implements MouseListener, MouseMotionListener {
    private Okno okno;

    public ObslugaMyszy(Okno okno){
        this.okno = okno;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String tekst = "";
        int przyscisk = e.getButton();
        switch (przyscisk){
            case MouseEvent.BUTTON1 -> {
                tekst = "przycisk1";
                break;
            } case MouseEvent.BUTTON2 -> {
                tekst = "przycisk2";
                break;
            } case MouseEvent.BUTTON3 -> {
                tekst = "przycisk3";
                break;
            }
        }
        tekst += ", x = " +e.getX() + ", y = " + e.getY();
        okno.setTekst(tekst);
        okno.setX(e.getX());
        okno.setY(e.getY());
        okno.repaint(); // teraz automatycznie
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
        okno.addPunkt(e.getX(), e.getY());
        okno.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

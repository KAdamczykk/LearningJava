import javax.swing.*;

public class OptionPany {
    public static void main(String[] args) {
        // standardowe basicowe okna sluzace do komunikacji z uzytkownikiem

        // okna z komunikatami:
        //JOptionPane.showMessageDialog(null, "Shitt", "OMG", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Shitt", "OMG", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Shitt", "OMG", JOptionPane.ERROR_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Shitt", "OMG", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Shitt", "OMG", JOptionPane.WARNING_MESSAGE);

        // rozmowa z uzytkownikiem
        //JOptionPane.showConfirmDialog(null, "shitt", "Title", JOptionPane.YES_NO_CANCEL_OPTION); // przechwytujemy jako int
        JOptionPane.showInputDialog(null, "Name: " ); // przechwytujemy jako string

        // rozbudowane okno
        //String[] rep = {"Yea", "Bro", "Nice"};
        //JOptionPane.showOptionDialog(null, "Nice dick", "Important", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,rep, 0);



    }
}

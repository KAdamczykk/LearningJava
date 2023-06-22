import javax.swing.*;
import java.awt.*;

public class PolaTextowe {
    public static class Framik extends JFrame{
        JTextField field;
        JButton button;
        public Framik(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            button = new JButton();
            field = new JTextField();
            field.setPreferredSize(new Dimension(250,40));
            button.setText("Klik");
            button.setSize(100,50);
            button.addActionListener(e -> {
                button.setEnabled(false); // pojedyncze klikniecie tylko
                System.out.println("Hi " + this.field.getText());
            });
            this.add(button);
            this.add(field);
            this.setVisible(true);
            this.pack();
        }

    }

    public static void main(String[] args) {
        Framik framik = new Framik();
    }
}

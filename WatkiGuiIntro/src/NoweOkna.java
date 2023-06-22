import javax.swing.*;

public class NoweOkna {
    public static class OknoStartowe  {
        JFrame jFrame = new JFrame();
        public OknoStartowe(){
            jFrame.setSize(300,300);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton button = new JButton("Nie klikoj");
            button.addActionListener(e -> {
                jFrame.dispose(); // zamknie nam ta ramke
                new OknoInne();});
            jFrame.add(button);

        }
    }
    public static class OknoInne extends JFrame{
        public OknoInne(){
            this.setLayout(null);
            this.setSize(300,300);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel("Heehe" );
            label.setSize(100,100);
            this.add(label);

        }
    }

    public static void main(String[] args) {
        new OknoStartowe();
    }
}

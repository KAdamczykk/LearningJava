import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
public class ExampleTask2 {
    public static class Kotek extends JFrame {
        public Kotek(){
            this.setSize(300,150);
            this.setLayout(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            panel1.setBounds(0,0,300,50);
            panel2.setBounds(0,50,300,100);
            Map<Integer, String> wersy = new LinkedHashMap<>();
            String[] words = {"Wlazł kotek na płotek", "I mruga", "Ładna to piosenka", "Niedluga", "Niedluga, niekrotka", "lecz w sam raz", "Zaspiewaj koteczku", "Jeszcze raz"};
            for (int i = 0; i <words.length; i++){
                wersy.put(i, words[i]);
            }
            JSlider slider = new JSlider(0, wersy.size() -1 , 0);
            slider.setMajorTickSpacing(1);
            JLabel label = new JLabel();
            slider.addChangeListener(e -> {label.setText(wersy.get(slider.getValue()));});
            panel1.add(slider);
            this.add(panel1);
            panel2.add(label);
            this.add(panel2);
            this.setResizable(false);
        }
    }
    public static class KotekPrzyciskowy extends JFrame{
        public KotekPrzyciskowy(){
            this.setSize(500,150);
            this.setLayout(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
            panel1.setBounds(0,0,500,50);
            JPanel panel2 = new JPanel();
            panel2.setBounds(0,50,500,100);
            JLabel label = new JLabel();

            String[] words = {"Wlazł kotek na płotek", "I mruga", "Ładna to piosenka", "Niedluga", "Niedluga, niekrotka", "lecz w sam raz", "Zaspiewaj koteczku", "Jeszcze raz"};
            for (int i = 0; i < words.length; i++){
                JButton button = new JButton(""+i);
                button.addActionListener(e -> {
                    label.setText(words[Integer.parseInt((button.getText()))]);
                });
                label.setVerticalAlignment(JLabel.TOP);
                panel1.add(button);
            }
            panel2.add(label);
            this.add(panel1);
            this.add(panel2);
            this.setResizable(false);
        }
    }
    public static void main(String[] args) {
        // new Kotek();
        // new KotekPrzyciskowy();
    }
}

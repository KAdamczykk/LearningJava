import javax.swing.*;
import java.awt.*;


public class Checkboxy {
    public static class MyFrame extends JFrame {
        JButton button;
        JCheckBox checkBox;

        public MyFrame(){
            this.setLayout(new FlowLayout());
            this.setTitle("Example");
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            button = new JButton("Klyk");
            button.addActionListener(e -> System.out.println(checkBox.isSelected()));
            checkBox = new JCheckBox();
            checkBox.setText("U a stupid");
            checkBox.setFocusable(false);
            this.add(checkBox);
            this.add(button);
            this.pack();

            // jak chcemy zeby zdjecia przelaczalo to na true dajemy selectedIcon

        }


    }
    public static class RadioBox extends JFrame{

        public RadioBox(){
            this.setLayout(new FlowLayout());
            this.setTitle("Example");
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JRadioButton pizza = new JRadioButton("Pizza");
            JRadioButton burger = new JRadioButton("Burger");
            JRadioButton kotlet = new JRadioButton("Kotlet");
            ButtonGroup group = new ButtonGroup(); // grupa zeby wybierac pojedynczo
            group.add(pizza);
            group.add(burger);
            group.add(kotlet);
            pizza.addActionListener(e -> System.out.println("Pizzka"));
            burger.addActionListener(e -> System.out.println("Burgero"));
            kotlet.addActionListener(e -> System.out.println("Kotlecik"));
            this.add(pizza);
            this.add(burger);
            this.add(kotlet);
            this.pack();
        }
    }
    public static class ComboBoxy extends JFrame{
        public ComboBoxy(){
            this.setLayout(new FlowLayout());
            this.setTitle("Example");
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JComboBox<Integer> comboBox = new JComboBox<>();
            for (int i = 18; i<31; i++){
                comboBox.addItem(i);
            }
            comboBox.addActionListener(e -> System.out.println(comboBox.getSelectedItem()));
            /* Metody dla ComboBoxow
            comboBox.getSelectedIndex();
            comboBox.insertItemAt();
            comboBox.remove();
            comboBox.setSelectedIndex();
            comboBox.getItemCount();
            comboBox.setEditable();
            this.add(comboBox); */
            this.pack();
        }
    }
    public static class Sliders extends JFrame{
        Sliders() {
            this.setSize(420,420);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            JLabel label = new JLabel();

            JSlider slider = new JSlider(0, 100, 50); // min , max wartosc, start suwaka,
            slider.setPreferredSize(new Dimension(350,300));
            slider.setPaintTicks(true);
            slider.setMinorTickSpacing(10); // podzialka co ile mala
            slider.setPaintTrack(true);
            slider.setMajorTickSpacing(25); // duza
            // slider.setPaintLabels(true); // tylko duze pisze skale idk czemu nie dziala

            // slider.setOrientation(SwingConstants.VERTICAL); obraca slider
            slider.addChangeListener(e -> {label.setText("Value " + slider.getValue());});

            panel.add(slider);
            panel.add(label);
            this.add(panel);
        }

    }
    public static void main(String[] args) {
       // new MyFrame();
        //new RadioBox();
      //  new ComboBoxy();
        new Sliders();
    }
}

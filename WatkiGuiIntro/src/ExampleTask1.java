import javax.swing.*;
import java.awt.*;

public class ExampleTask1 {
    public static class InputWindow extends JFrame{
        public InputWindow(){
            this.setVisible(true);
            this.setLayout(new FlowLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            //panel.setLayout(new FlowLayout());
            JLabel l1 = new JLabel("Enter your name: ");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(250,30));
            JComboBox<Integer> comboBox = new JComboBox<>();
            for (int i = 20; i < 51; i++){
                comboBox.addItem(i);
            }
            JLabel l2 = new JLabel(" and age: ");
            JButton button  = new JButton("Submit");
            button.setSize(150,100);
            button.addActionListener(e -> {
                this.dispose();
                new OutputWindow(textField.getText(), (Integer) comboBox.getSelectedItem());
            });
            panel.add(l1);
            panel.add(textField);
            panel.add(l2);
            panel.add(comboBox);
            panel.add(button);
            this.add(panel);
            this.pack();
        }
    }
    public static class OutputWindow extends JFrame{

        public OutputWindow(String name, int age){
            this.setLayout(new FlowLayout());
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel(name + " has "+age+ " yo.");
            this.add(label);
            this.pack();
        }
    }

    public static void main(String[] args) {
        new InputWindow();
    }
}

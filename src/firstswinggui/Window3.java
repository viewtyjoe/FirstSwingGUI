package firstswinggui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window3 extends JFrame implements ActionListener {
    private JButton sayByeButton;
    private JLabel label;
    private Container c;
    private static int count = 0;
    
    public Window3() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        sayByeButton = new JButton("Say Bye");
        sayByeButton.addActionListener(this);
        c.add(sayByeButton);
        label = new JLabel("");
        c.add(label);
        setSize(400, 300); // need to explicity size the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sayByeButton) {
            label.setText("Bye, counter = " + ++count);
        } else if(e.getActionCommand().equals("helloButton")) {
            label.setText("Hello message copied from Window2");
        }
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    public static void main(String[] args) {
        new Window3();
    }
}

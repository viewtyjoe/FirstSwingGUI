package firstswinggui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window2 extends JFrame implements ActionListener {
    private static int count = 0;
    private JButton sayHelloButton;
    private JLabel label;
    private Container c;
    
    public Window2(ActionListener window3) {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        sayHelloButton = new JButton("Say Hello");
        sayHelloButton.setActionCommand("helloButton");
        sayHelloButton.addActionListener(this);
        sayHelloButton.addActionListener(window3);
        c.add(sayHelloButton);
        label = new JLabel("");
        c.add(label);
        setSize(400, 300); // need to explicity size the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        label.setText("Hello, counter = " + ++count);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    

}

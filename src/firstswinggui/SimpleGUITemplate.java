package firstswinggui;

// Most Swing GUI classes need to import classes from these

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// packages, but there could be others you will need...


/*
 * A JFrame is the most basic and common type of GUI container. However,
 * in a more sophisticated GUI you might create separate JPanel classes 
 * to be used as child component containers of the JFrame. And JPanel objects
 * may contain other JPanel objects. Through this layering of components you
 * can control the layout and provide a way that you can
 * reuse parts of a GUI in other projects and/or JFrames.
 * 
 * If you intend to do event handling, you will need to implement at 
 * least one interface. ActionListener is the most generic type. There 
 * are other ways to do event handling, using adapters, e.g., or 
 * using anonymous inner classes.
 */
public class SimpleGUITemplate extends JFrame implements ActionListener {
	
	// Typically you begin by declaring the components you will need
	// as instance variables.
	private JPanel panel1;
	private Container c;
	private JButton button1, button2;
	private JLabel label1;
	private int counter;
	
	// Not necessary but makes your program more modular
	public SimpleGUITemplate() {
		super("Window Title");  // not necessary but recommended
		init();
	}
	
	// helper method, doesn't need to be public
	private void init() {
        // This is where you normally place your GUI components. There are
        // other container layers in a JFrame, however.
		c = getContentPane();
		
		// If these are there, you won't see the buttons
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		button1 = new JButton("Click Me");
		button2 = new JButton("Now I'm Visible");
                button2.setVisible(false);

		// Hook up the button to the event handler
		button1.addActionListener(this);
		button2.addActionListener(this);

		label1 = new JLabel("Hello, I'm a Label Component");
		
		// The way you add components varies with the layout manager used
		panel1.add(button2, BorderLayout.NORTH);
		panel1.add(button1, BorderLayout.CENTER);
		panel1.add(label1,BorderLayout.SOUTH);
		c.add(panel1,BorderLayout.CENTER);

		setSize(400, 300); // explicity sizes the window
//		pack();    // sizes window according to preferred sizes of components
                           // use pack() or setSize(), but not both.
                
                // causes window to be centered (null means no parent window)
                // If parent exists, then relative to parent.
                this.setLocationRelativeTo(null);

		// By default, when you close a window it is just hidden; the object is
        // still active in memory. This setting causes the object to be deleted.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
     * A generic event handler for the buttons. This method is called automatically
     * by the actionListener referenced above (the current JFrame), but it could
     * be some other object. Swing components handle events on a separate thread
     * called the event dispatch thread. That means all event processing is done
     * on that thread and not on the main application thread. Be careful that
     * you don't monopolize this thread with too much processing code, or your
     * GUI will not be responsive.
     */
	public void actionPerformed(ActionEvent ae) {
		// The ActionEvent object (ae) has info about the event.
        // You have two options to determine what triggered the event: ae.getSource() or
		// ae.getActionCommand(). The later is only used if you
		// first set the action command String
		if(ae.getSource() == button1) {
			counter++;
			label1.setText("You clicked me " + counter + " times");
			button2.setVisible(true);
		} else if(ae.getSource() == button2) {
                    // hide button 2
                    button2.setVisible(false);
                } else {
                    // if this is a long running task create a separate thread
                    // to do the work on an anonyous inner class:
                    Thread t = new Thread() {
                        public void run() {
                            // long running code here
                        }
                    };
                    t.start();
                }
	}

}

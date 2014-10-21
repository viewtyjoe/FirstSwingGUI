package firstswinggui;

import javax.swing.UIManager;

/**
 * A startup class. Just start the GUI...
 */
public class Startup {

    /**
     * @param args the command line arguments not used
     */
    public static void main(String[] args) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // do nothing, this can safely be ignored because
            // it will fall back to the basic metal L&F if something
            // goes wrong. This is also a rare example of a scenario
            // where the catch clause could be safely eliminated.
        }

        /* 
            Create and display the form  on a separate thread using
            JDK 7 or earlier syntax, which rquires an anonymous inner class
        */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new SimpleGUITemplate().setVisible(true);
//                Window3 w3 = new Window3();
//                w3.setVisible(true);
//                new Window2(w3).setVisible(true);
//            }
//        });
        
        /*
            Create and display the form on a separate thread using the new
            Lambda (closure) capability of JDK 8+
        */
        java.awt.EventQueue.invokeLater(() -> {
            new SimpleGUITemplate().setVisible(true);
//            Window3 w3 = new Window3();
//            w3.setVisible(true);
//            new Window2(w3).setVisible(true);
        });
        
    }

}

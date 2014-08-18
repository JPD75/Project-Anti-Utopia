package core;

import javax.swing.JFrame;

/**
 *
 * @author Jacob
 */
public class Main extends JFrame {

    public Main() {
        
        setTitle("Project Anti-Utopia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main frame = new Main();
    }

}

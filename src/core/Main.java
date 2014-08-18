package core;

import data.Entities;
import data.Tiles;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Jacob
 */
public class Main extends JFrame {

    public static Main m;
    public static Display d;
    
    public Main() {
        
        d = new Display();
        
        setTitle("Project Anti-Utopia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        add(d);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        d.startGame();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        m = new Main();
    }
    
    public void render(){
     
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.dispose();
        bs.show();
        
    }

}

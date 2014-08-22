package core;

import data.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import world.Chunk;
import world.World;

/**
 *
 * @author Jacob
 */
public class Main extends JFrame {

    public static Main m;
    public static Display d;
    public static World w;
    
    public Main() {
        
        d = new Display();
        w = new World(64, 64);
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
                  
       for(int y = 0; y < w.width; y++){
           for(int x = 0; x < w.length; x++){
               Tiles tile = w.getBlock(x, y);
               g.drawImage(tile.image, x * 64, y * 64, null);
           }
       }
        
        g.dispose();
        bs.show();
        
    }

}

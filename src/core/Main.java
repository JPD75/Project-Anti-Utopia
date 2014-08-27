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
        setSize(1920,1080);
        add(d);
        setResizable(true);
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
       
       for(int i = 0; i < w.entity.size(); i ++){
           g.drawImage(w.entity.get(i).image, w.entity.get(i).x * 64, w.entity.get(i).y * 64, null);
       }
       for(int i = 0; i < w.player.size(); i ++){
           g.drawImage(w.player.get(i).image, w.player.get(i).x * 64, w.player.get(i).y * 64, null);
       }
       for(int i = 0; i < w.armor.size(); i ++){
           g.drawImage(w.armor.get(i).image, w.player.get(0).x * 64, w.player.get(0).y * 64, null);
       }
       
        g.dispose();
        bs.show();
        
    }

}

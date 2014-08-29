
package input;

import core.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Torri
 */
public class Keyboard implements KeyListener{
    private final boolean[] keys = new boolean[1000];
    private int[] keyn = {KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D};
    public boolean[] keyBind = new boolean[4];
    /**
     * Sets up a keyboard input listener
     * @param keybinds 
     */
    public Keyboard(){
        
        for(boolean k: keys){
            k=false;
        }
    }
    /**
     * changes settings w/o making new instance
     * @param kb 
     */
    public void checkSettings(String[] kb){
        for(int i=0;i<kb.length;i++){
            keyn[i]=Integer.parseInt(kb[i]);
        }
    }
    /**
     * Receives when key is typed
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if(keyBind[0]){
            Main.offY --;
        }
        if(keyBind[1]){
            Main.offY ++;
        }
        if(keyBind[2]){
            Main.offX --;
        }
        if(keyBind[3]){
            Main.offX ++;
        }
    }
    /**
     * Receives when key is pressed
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        for(int i=0;i<keyBind.length;i++){
            keyBind[i]=keys[keyn[i]];
        }
    }
    /**
     * Receives when key is released
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
        for(int i=0;i<keyBind.length;i++){
            keyBind[i]=keys[keyn[i]];
        }
    }
}

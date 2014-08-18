
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;


import javax.swing.JPanel;

/**
 *
 * @author Jacob
 */
public class Display extends JPanel implements Runnable{
    
    private boolean running = false;
    private Thread thread;
    
    public Display(){
        
    }

    @Override
    public void run() {
        
        while(running){
           Main.m.render();
        }
    }
    
    public synchronized void startGame(){
        running = true;
        thread = new Thread(this, "Game");
        thread.start();
        
    }
    
    public synchronized void stopGame(){
        running = false;
        thread.interrupt();
    }
    
   
    
}

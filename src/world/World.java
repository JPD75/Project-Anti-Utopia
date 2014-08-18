/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

/**
 *
 * @author Jacob
 */

public class World {
    
    public Chunk[] chunks;
    
    public World(int l, int w){
        chunks = new Chunk[(l / 16) * (w / 16)];
        int y = -1;
        for(int i = 0; i < chunks.length; i ++){
            int x = (i % (l / 16)) * 16;
            if(x == 0) y += 16;
            chunks[i] = new Chunk(x, y);
        }
    }
    
    public void generateMineshaft(int x, int y, int l, boolean r){
        
    }
    
    public void generateDragonTemple(int x, int y){
        
    }
    
    
}

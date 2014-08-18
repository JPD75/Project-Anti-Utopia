/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import data.Tiles;

/**
 *
 * @author Jacob
 */

public class Chunk {
   
    public int[] data = new int[16 * 16];
    public int[] damage = new int[16 * 16];
    
    int x;
    int y;
    
    public Chunk(int x, int y){
        for(int i = 0; i < data.length; i ++){
            data[i] = Tiles.STONE.ordinal();
        }
    }
    
}

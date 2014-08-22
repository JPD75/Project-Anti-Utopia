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
   
    public static int size = 16;
    public int[] data = new int[size * size];
    public int[] damage = new int[size * size];
    
    int x;
    int y;
    
    public Chunk(int x, int y){
        for(int cy = 0; cy < size; cy ++){
            for(int cx = 0; cx < size; cx ++){
            data[cx + cy * size] = Tiles.STONE.ordinal();
        }
        }
        
    }
    
}

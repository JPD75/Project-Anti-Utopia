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
   
    public int[][] data = new int[16][16];
    public int[][] damage = new int[16][16];
    
    int x;
    int y;
    
    public Chunk(int x, int y){
        for(int cy = 0; cy < 16; cy ++){
            for(int cx = 0; cx < 16; cx ++){
            data[cx][cy] = Tiles.STONE.ordinal();
        }
        }
        
    }
    
}

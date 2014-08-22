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

public class World {
    
    public Chunk[] chunks;
    public int length, width;
    
    public World(int l, int w){
        chunks = new Chunk[(l / Chunk.size) * (w / Chunk.size)];
        length = l;
        width = w;
        for(int y = 0; y < w / Chunk.size; y++){
            for(int x = 0; x < l / Chunk.size; x ++){
                chunks[x + y * (l / Chunk.size)] = new Chunk(x * Chunk.size, y * Chunk.size);
            }
        }
        
    }
    
    public Tiles getBlock(int x, int y){
        
        int xChunk = x / Chunk.size;
        int yChunk = y / Chunk.size;
        int chunkRows = length / Chunk.size;
        
        Chunk c = chunks[xChunk + yChunk * chunkRows];
        
        int xPos = x % Chunk.size;
        int yPos = y % Chunk.size;
        
        int blockType = c.data[xPos + yPos * Chunk.size];
        
        Tiles block = Tiles.values()[blockType];
        
        return block;
        
    }
    
    public void setBlock(Tiles block, int x, int y){
        
        int xChunk = x / Chunk.size;
        int yChunk = y / Chunk.size;
        int chunkRows = length / Chunk.size;
        
        Chunk c = chunks[xChunk + yChunk * chunkRows];
        
        int xPos = x % Chunk.size;
        int yPos = y % Chunk.size;
        
        c.data[xPos + yPos * Chunk.size] = block.ordinal();
    }
    
    public void generateMineshaft(int x, int y, int l, boolean r){
        
    }
    
    public void generateDragonTemple(int x, int y){
        
    }
    
    
}

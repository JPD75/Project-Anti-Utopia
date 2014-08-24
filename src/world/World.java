/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import data.Entities;
import data.Tiles;
import entity.Entity;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class World {

    public Chunk[] chunks;
    public ArrayList<Entity> entity = new ArrayList<>();
    public int length, width;

    public World(int l, int w) {
        chunks = new Chunk[(l / Chunk.size) * (w / Chunk.size)];
        length = l;
        width = w;
        for (int y = 0; y < w / Chunk.size; y++) {
            for (int x = 0; x < l / Chunk.size; x++) {
                chunks[x + y * (l / Chunk.size)] = new Chunk(x * Chunk.size, y * Chunk.size);
            }
        }
    
        generateSquare(0,0,5, Tiles.AIR);
        /*
        generateDragonTemple(0, 0);
        
        generateMineshaft(2, 2, 7, true);
        generateMineshaft(2, 6, 3, false);
        
        
        setBlock(Tiles.URANIUM_ORE, 1, 1);
        setBlock(Tiles.URANIUM_ORE, 3, 1);
        setBlock(Tiles.URANIUM_ORE, 2, 2);
        setBlock(Tiles.URANIUM_ORE, 0, 3);
        setBlock(Tiles.URANIUM_ORE, 1, 4);
        setBlock(Tiles.URANIUM_ORE, 2, 4);
        setBlock(Tiles.URANIUM_ORE, 3, 4);
        setBlock(Tiles.URANIUM_ORE, 4, 3);
    */
        
        new Entity(Entities.BEHEMOTH, this);
        
    }

    public Tiles getBlock(int x, int y) {

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

    public void setBlock(Tiles block, int x, int y) {

        int xChunk = x / Chunk.size;
        int yChunk = y / Chunk.size;
        int chunkRows = length / Chunk.size;

        Chunk c = chunks[xChunk + yChunk * chunkRows];

        int xPos = x % Chunk.size;
        int yPos = y % Chunk.size;

        c.data[xPos + yPos * Chunk.size] = block.ordinal();
    }

    public void generateMineshaft(int x, int y, int l, boolean r) {
        int lvl = 0;
        if (r) {
            for(int cols = y; cols < y + 3; cols ++){
                for(int rows = x; rows < x + l; rows ++){
                    switch(lvl){
                        case 0:
                            setBlock(Tiles.WOOD, rows, cols);
                            break;
                        case 1:
                            setBlock(Tiles.AIR, rows, cols);
                            break;
                        case 2:
                            setBlock(Tiles.WOOD, rows, cols);
                            break;
                    }
                }
                lvl ++;
            }
            lvl = 0;
        }
        else if (!r) {
            for(int rows = x; rows < x + 3; rows ++){
                for(int cols = y; cols < y + l; cols ++){
                    switch(lvl){
                        case 0:
                            setBlock(Tiles.WOOD, rows, cols);
                            break;
                        case 1:
                            setBlock(Tiles.AIR, rows, cols);
                            break;
                        case 2:
                            setBlock(Tiles.WOOD, rows, cols);
                            break;
                    } 
                }
                lvl ++;
            }
            lvl = 0;
        }

    }

    public void generateDragonTemple(int x, int y) {
        int dtSize = 50;
        generateSquare(x, y, dtSize, Tiles.TEMPLEBRICK);
        generateSquare(x + 1, y + 1, dtSize - 2, Tiles.AIR);
    }

    public void generateCave(int x, int y) {

    }

    public void generateSquare(int x, int y, int size, Tiles tile) {

        for (int rows = x; rows < x + size; rows++) {
            for (int cols = y; cols < y + size; cols++) {
                setBlock(tile, rows, cols);
            }
        }

    }

}

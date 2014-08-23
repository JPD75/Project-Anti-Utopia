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

    public World(int l, int w) {
        chunks = new Chunk[(l / Chunk.size) * (w / Chunk.size)];
        length = l;
        width = w;
        for (int y = 0; y < w / Chunk.size; y++) {
            for (int x = 0; x < l / Chunk.size; x++) {
                chunks[x + y * (l / Chunk.size)] = new Chunk(x * Chunk.size, y * Chunk.size);
            }
        }

        //generateSquare(0, 0, 5, Tiles.AIR);
        
        generateDragonTemple(0, 0);
        
        setBlock(Tiles.URANIUM_ORE, 1, 1);
        setBlock(Tiles.URANIUM_ORE, 3, 1);
        setBlock(Tiles.URANIUM_ORE, 2, 2);
        setBlock(Tiles.URANIUM_ORE, 0, 3);
        setBlock(Tiles.URANIUM_ORE, 1, 4);
        setBlock(Tiles.URANIUM_ORE, 2, 4);
        setBlock(Tiles.URANIUM_ORE, 3, 4);
        setBlock(Tiles.URANIUM_ORE, 4, 3);

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

        if (r) {

        }
        if (!r) {

        }

    }

    public void generateDragonTemple(int x, int y) {
        int dtSize = 50;
        for (int rows = x; rows < x + dtSize; rows++) {
            for (int cols = y; cols < y + dtSize; cols++) {
                if (rows == 0 || rows == dtSize - 1 || cols == 0 || cols == dtSize - 1) {
                    setBlock(Tiles.TEMPLEBRICK, rows, cols);
                } else {
                    setBlock(Tiles.AIR, rows, cols);
                }
            }
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import data.Armor;
import data.Entities;
import data.Players;
import data.Tiles;
import entity.Armour;
import entity.Entity;
import entity.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jacob
 */
public class World {

    public Chunk[] chunks;
    public ArrayList<Entity> entity = new ArrayList<>();
    public ArrayList<Player> player = new ArrayList<>();
    public ArrayList<Armour> armor = new ArrayList<>();
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

        //World Generation From Here:
        
        
        
        
        
        //To Here
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
            for (int cols = y; cols < y + 3; cols++) {
                for (int rows = x; rows < x + l; rows++) {
                    switch (lvl) {
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
                lvl++;
            }
            lvl = 0;
        } else if (!r) {
            for (int rows = x; rows < x + 3; rows++) {
                for (int cols = y; cols < y + l; cols++) {
                    switch (lvl) {
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
                lvl++;
            }
            lvl = 0;
        }

    }

    public void generateDragonTemple(int x, int y) {
        int dtSize = 24;
        generateSquare(x, y, dtSize, Tiles.TEMPLEBRICK);
        generateSquare(x + 1, y + 1, dtSize - 2, Tiles.AIR);
    }

    public void generateLongCave(int x, int y) {
        
        Random r = new Random();
        
        int squares = r.nextInt(10) + 5;
        int[] xValues = new int[squares];
        int[] yValues = new int[squares];
        int[] size = new int[squares];
        
        
        xValues[0] = x;
        yValues[0] = y;
        size[0] = r.nextInt(3) + 3;
                
        generateSquare(xValues[0], yValues[0], size[0], Tiles.AIR);
        
        for(int i = 1; i < squares; i ++){
            
            xValues[i] = r.nextInt(size[i - 1]) + xValues[i - 1];
            yValues[i] = r.nextInt(size[i - 1]) + yValues[i - 1];
            size[i] = r.nextInt(4) + 2;
            
            generateSquare(xValues[i], yValues[i], size[i], Tiles.AIR);
        }
    }
    public void generateOpenCave(int x, int y){
        Random r = new Random();
        int squares = r.nextInt(15) + 5;
        int[] xValues = new int[squares];
        int[] yValues = new int[squares];
        int[] size = new int[squares];
        int xMove = 0, yMove = 0;
        
        xValues[0] = x;
        yValues[0] = y;
        size[0] = r.nextInt(3) + 3;
        
        generateSquare(xValues[0], yValues[0], size[0], Tiles.AIR);
        
        for(int i = 1; i < squares; i ++){
            xMove = r.nextInt(6) - 3;
            yMove = r.nextInt(6) - 3;
            size[i] = size[i - 1] + r.nextInt(4) - 2;
            
            if(size[i] > 15){
                size[i] = 15;
            }else if(size[i] < 5){
                size[i] = 5;
            }
            
            xValues[i] = xValues[i - 1] + xMove;
            yValues[i] = yValues[i - 1] + yMove;
            
            //Take out when unlimited world
            if(xValues[i] <= 0){
                xValues[i] = 0;
            }if(yValues[i] <= 0){
                yValues[i] = 0;
            }
            
            System.out.println("" + xValues[i] + " " + yValues[i] + " " + size[i]);
            
            generateSquare(xValues[i], yValues[i], size[i], Tiles.AIR);
            
        }
    }

    public void generateSquare(int x, int y, int size, Tiles tile) {

        for (int rows = x; rows < x + size; rows++) {
            for (int cols = y; cols < y + size; cols++) {
                setBlock(tile, rows, cols);
            }
        }

    }

    public void generateOres(int x, int y) {

        Random r = new Random();
        Tiles t;
        int size;
        int oreChance = r.nextInt(14);
        int ore = 0;

        if (oreChance == 0) {
            ore = 6;
        }
        if (oreChance >= 1 && oreChance <= 3) {
            ore = 5;
        }
        if (oreChance > 3 && oreChance <= 7) {
            ore = 4;
        }
        if (oreChance > 7 && oreChance <= 14) {
            ore = 1;
        }

        t = Tiles.values()[ore];

        switch (ore) {
            case 1:
                size = 7;
                break;
            case 4:
                size = 4;
                break;
            case 5:
                size = 3;
                break;
            case 6:
                size = 2;
                break;
            default:
                size = 1;
                break;
        }

        for (int i = x; i < size + x; i++) {
            for (int j = y; j < size + y; j++) {
                if (r.nextInt(100) > 35) {
                    setBlock(t, i, j);
                }
            }
        }
    }
}

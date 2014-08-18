/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jacob
 */
public enum Tiles {

    STONE(0, 0, true, 100), DIRT(64, 0, true, 50), WOOD(128, 0, true, 75), AIR(192, 0, false, 0),
    
    COAL(0, 64, true, 125), IRON(64, 64, true, 150), URANIUM(128, 64, true, 200), TEMPLEBRICK(192, 64, true, 300),
    
    CHEST(0, 128, true, 75), TORCH(64, 128, false, 1), FIRE1(128, 128, false, 20), FIRE2(192, 128, false, 20);
    
    public BufferedImage blockImage;
    private BufferedImage blockSpriteSheet = (new assets.LoadArt()).createBufferedImage("blocks.png");
    
    public boolean solid;
    public int durability;

    private Tiles(int x, int y, boolean solid, int durability) {
        
        this.solid = solid;
        this.durability = durability;
        
        blockImage = blockSpriteSheet.getSubimage(x, y, 64, 64);
        
    }
}

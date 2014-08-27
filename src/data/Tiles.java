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

    STONE(0, 0, true, false, 100), DIRT(1, 0, true, true, 50), WOOD(2, 0, true, false, 75), AIR(3, 0, false, false, 0),
    
    COAL_ORE(0, 1, true, true, 125), IRON_ORE(1, 1, true, true, 150), URANIUM_ORE(2, 1, true, true, 200), TEMPLEBRICK(3, 1, true, false, 300),
    
    CHEST(0, 2, true, false, 75), TORCH(1, 2, false, false, 1), FIRE1(2, 2, false, false, 20), FIRE2(3, 2, false, false, 20);
    
    public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("blocks.png");
    
    public boolean solid, isOre;
    public int durability;

    private Tiles(int x, int y, boolean solid, boolean isOre, int durability) {
        
        this.solid = solid;
        this.isOre = isOre;
        this.durability = durability;
        
        image = spriteSheet.getSubimage(x * 64, y * 64, 64, 64);
        
    }
}

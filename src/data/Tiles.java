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

    STONE(0, 0, true, 100), DIRT(1, 0, true, 50), WOOD(2, 0, true, 75), AIR(3, 0, false, 0),
    
    COAL_ORE(0, 1, true, 125), IRON_ORE(1, 1, true, 150), URANIUM_ORE(2, 1, true, 200), TEMPLEBRICK(3, 1, true, 300),
    
    CHEST(0, 2, true, 75), TORCH(1, 2, false, 1), FIRE1(2, 2, false, 20), FIRE2(3, 2, false, 20);
    
    public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("blocks.png");
    
    public boolean solid;
    public int durability;

    private Tiles(int x, int y, boolean solid, int durability) {
        
        this.solid = solid;
        this.durability = durability;
        
        image = spriteSheet.getSubimage(x * 64, y * 64, 64, 64);
        
    }
}

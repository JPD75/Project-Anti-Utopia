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
public enum Armor {

    WOOD_TORSO_UP(0, 0, 0, 0, 1), WOOD_TORSO_RIGHT(1, 0, 0, 1, 1), WOOD_PANTS_UP(2, 0, 0, 0, 2), WOOD_PANTS_RIGHT(3, 0, 0, 1, 2), STONE_TORSO_UP(4, 0, 1, 0, 1), STONE_TORSO_RIGHT(5, 0, 1, 1, 1), STONE_PANTS_UP(6, 0, 1, 0, 2), STONE_PANTS_RIGHT(7, 0, 1, 1, 2),
    
    WOOD_TORSO_BACK(0, 1, 0, 3, 1), WOOD_TORSO_LEFT(1, 1, 0, 2, 1), WOOD_PANTS_BACK(2, 1, 0, 3, 2), WOOD_PANTS_LEFT(3, 1, 0, 2, 2), STONE_TORSO_BACK(4, 1, 1, 3, 1), STONE_TORSO_LEFT(5, 1, 1, 2, 1), STONE_PANTS_BACK(6, 1, 1, 3, 2), STONE_PANTS_LEFT(7, 1, 1, 2, 2),
    
    WOOD_HELMET_UP(0, 2, 0, 0, 0), WOOD_HELMET_RIGHT(1, 2, 0, 1, 0), WOOD_BOOTS_UP(2, 2, 0, 0, 3), WOOD_BOOTS_RIGHT(3, 2, 0, 1, 3), STONE_HELMET_UP(4, 2, 1, 0, 0), STONE_HELMET_RIGHT(5, 2, 1, 1, 0), STONE_BOOTS_UP(6, 2, 1, 0, 3), STONE_BOOTS_RIGHT(7, 2, 1, 1, 3),
    
    WOOD_HELMET_BACK(0, 3, 0, 3, 0), WOOD_HELMET_LEFT(1, 3, 0, 2, 0), WOOD_BOOTS_BACK(2, 3, 0, 3, 3), WOOD_BOOTS_LEFT(3, 3, 0, 2, 3), STONE_HELMET_BACK(4, 3, 1, 3, 0), STONE_HELMET_LEFT(5, 3, 1, 2, 0), STONE_BOOTS_BACK(6, 3, 1, 3, 3), STONE_BOOTS_LEFT(7, 3, 1, 2, 3),
    
    IRON_TORSO_UP(0, 4, 2, 0, 1), IRON_TORSO_RIGHT(1, 4, 2, 1, 1), IRON_PANTS_UP(2, 4, 2, 0, 2), IRON_PANTS_RIGHT(3, 4, 2, 1, 2), URANIUM_TORSO_UP(4, 4, 3, 0, 1), URANIUM_TORSO_RIGHT(5, 4, 3, 1, 1), URANIUM_PANTS_UP(6, 4, 3, 0, 2), URANIUM_PANTS_RIGHT(7, 4, 3, 1, 2),
    
    IRON_TORSO_BACK(0, 5, 2, 3, 1), IRON_TORSO_LEFT(1, 5, 2, 2, 1), IRON_PANTS_BACK(2, 5, 2, 3, 2), IRON_PANTS_LEFT(3, 5, 2, 2, 2), URANIUM_TORSO_BACK(4, 5, 3, 3, 1), URANIUM_TORSO_LEFT(5, 5, 3, 2, 1), URANIUM_PANTS_BACK(6, 5, 3, 3, 2), URANIUM_PANTS_LEFT(7, 5, 3, 2, 2),
    
    IRON_HELMET_UP(0, 6, 2, 0, 0), IRON_HELMET_RIGHT(1, 6, 2, 1, 0), IRON_BOOTS_UP(2, 6, 2, 0, 3), IRON_BOOTS_RIGHT(3, 6, 2, 1, 3), URANIUM_HELMET_UP(4, 6, 3, 0, 0), URANIUM_HELMET_RIGHT(5, 6, 3, 1, 0), URANIUM_BOOTS_UP(6, 6, 3, 0, 3), URANIUM_BOOTS_RIGHT(7, 6, 3, 1, 3),
    
    IRON_HELMET_BACK(0, 7, 2, 3, 0), IRON_HELMET_LEFT(1, 7, 2, 2, 0), IRON_BOOTS_BACK(2, 7, 2, 3, 3), IRON_BOOTS_LEFT(3, 7, 2, 2, 3), URANIUM_HELMET_BACK(4, 7, 3, 3, 0), URANIUM_HELMET_LEFT(5, 7, 3, 2, 0), URANIUM_BOOTS_BACK(6, 7, 3, 3, 3), URANIUM_BOOTS_LEFT(7, 7, 3, 2, 3);
    

    public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("Armor.png");

    public int material;
    public int dir;
    public int article;
    
    private Armor(int x, int y, int material, int dir, int article) {

        this. material = material;
        this.dir = dir;
        this.article = article;
        
        image = spriteSheet.getSubimage(x * 64, y * 64, 64, 64);
        
    }
}

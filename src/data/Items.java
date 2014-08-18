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
public enum Items {
    
    
    WOOD_PICKAXE(0,0), STONE_PICKAXE(1,0), IRON_PICKAXE(2,0), URANIUM_PICKAXE(3,0), BOW1(4,0), FEATHER(5,0), TORCH(6,0), COAL(7,0), IRON(8,0), URANIUM(9,0),
    
    WOOD_SHOVEL(0,1), STONE_SHOVEL(1,1), IRON_SHOVEL(2,1), URANIUM_SHOVEL(3,1), BOW2(4,1), FLINT(5,1), WOOD_HELMET(6,1), STONE_HELMET(7,1), IRON_HELMET(8,1), URANIUM_HELMET(9,1),
    
    WOOD_AXE(0,2), STONE_AXE(1,2), IRON_AXE(2,2), URANIUM_AXE(3,2), BOW3(4,2), FLINT_STEEL(5,2), WOOD_CHESTPLATE(6,2), STONE_CHESTPLATE(7,2), IRON_CHESTPLATE(8,2), URANIUM_CHESTPLATE(9,2),
    
    WOOD_SWORD(0,3), STONE_SWORD(1,3), IRON_SWORD(2,3), URANIUM_SWORD(3,3), ARROW(4,3), DART_SHOOTER(5,3), WOOD_LEGGINGS(6,3), STONE_LEGGINGS(7,3), IRON_LEGGINGS(8,3), URANIUM_LEGGINGS(9,3),
    
    WOOD_ARROW(0,4), STONE_ARROW(1,4), IRON_ARROW(2,4), URANIUM_ARROW(3,4), STICK(4,4), DART(5,4), WOOD_BOOTS(6,4), STONE_BOOTs(7,4), IRON_BOOTS(8,4), URANIUM_BOOTS(9,4);
    
     public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("items.png");
    
    private Items(int x, int y){
        
        image = spriteSheet.getSubimage(x * 16, y * 16, 16, 16);
        
    }
}

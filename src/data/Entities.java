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
public enum Entities {

    SNAKE(0, 0, 25, 5, 25), BAT1(64, 0, 25, 5, 25), BAT2(128, 0, 25, 5, 25), SPIDER(192, 0, 35, 7, 20),
    
    GOBLIN(0, 64, 75, 12, 14), TROLL(64, 64, 150, 20, 9), DRAGON1(128, 64, 500, 100, 1), DRAGON2(192, 64, 500, 100, 1),
    
    GHOST(0, 192, 190, 40, 4), BEHEMOTH(64, 192, 270, 70, 2), DRAGON3(128, 128, 500, 100, 1), DRAGON4(192, 128, 500, 100, 1);
    
    public BufferedImage entityImage;
    private BufferedImage entitySpriteSheet = (new assets.LoadArt()).createBufferedImage("entities.png");
    
    public int health;
    public int damage;
    public double spawn;
    
    private Entities(int x, int y, int health, int damage, double spawn) {
        
        this.health = health;
        this.damage = damage;
        this.spawn = spawn;
        
        entityImage = entitySpriteSheet.getSubimage(x, y, 64, 64);
    }
}

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

    SNAKE(0, 0, 25, 5, 25), BAT1(1, 0, 25, 5, 25), BAT2(2, 0, 25, 5, 25), SPIDER(3, 0, 35, 7, 20),
    
    GOBLIN(0, 1, 75, 12, 14), TROLL(1, 1, 150, 20, 9), DRAGON1(2, 1, 500, 100, 1), DRAGON2(3, 1, 500, 100, 1),
    
    GHOST(0, 2, 190, 40, 4), BEHEMOTH(1, 2, 270, 70, 2), DRAGON3(2, 2, 500, 100, 1), DRAGON4(3, 2, 500, 100, 1);
    
    public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("entities.png");
    
    public int health;
    public int damage;
    public double spawn;
    
    private Entities(int x, int y, int health, int damage, double spawn) {
        
        this.health = health;
        this.damage = damage;
        this.spawn = spawn;
        
        image = spriteSheet.getSubimage(x * 64, y * 64, 64, 64);
    }
}

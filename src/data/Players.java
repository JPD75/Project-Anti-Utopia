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
public enum Players {

    UP(0, 0, 0, 25, 5), RIGHT(1, 0, 1, 25, 5),
    
    LEFT(0, 1, 2, 25, 5), DOWN(1, 1, 3, 25, 5);

    public BufferedImage image;
    private BufferedImage spriteSheet = (new assets.LoadArt()).createBufferedImage("Player.png");

    public int dir;
    public int health;
    public int damage;

    private Players(int x, int y, int dir, int health, int damage) {

        this.dir = dir;
        this.health = health;
        this.damage = damage;

        image = spriteSheet.getSubimage(x * 64, y * 64, 64, 64);
    }

}

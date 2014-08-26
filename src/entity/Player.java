/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import data.Players;
import data.Tiles;
import java.awt.image.BufferedImage;
import java.util.Random;
import world.World;

/**
 *
 * @author Jacob
 */
public class Player {
    
    public BufferedImage image;
    public static int x, y;
    public int dir, health, damage;
    
    public Player(Players p, World w){
        
        image = p.image;
        dir = p.dir;
        health = p.health;
        damage = p.damage;
        
        spawn(w);
        
    }
    
    public void spawn(World w){
        
        Random r = new Random();
        Tiles t = Tiles.STONE;
        while(t.solid){
            x = r.nextInt(w.length * 2) % w.length;
            y = r.nextInt(w.width * 2) % w.width;
            t = w.getBlock(x, y);
        }
        
        w.player.add(this);
        
    }
    
}

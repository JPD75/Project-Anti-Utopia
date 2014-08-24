/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import core.Main;
import data.Entities;
import data.Tiles;

import java.awt.image.BufferedImage;
import java.util.Random;
import world.World;

/**
 *
 * @author Jacob
 */

public class Entity {
    
    public BufferedImage image;
    public int x, y;
    public int health, damage;
    
    public Entity(Entities e, World w){
        
        image = e.image;
        health = e.health;
        damage = e.damage;
        
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
        w.entity.add(this);
    }
    
}

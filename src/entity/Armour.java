/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import data.Armor;
import data.Tiles;
import java.awt.image.BufferedImage;
import java.util.Random;
import world.World;

/**
 *
 * @author Jacob
 */
public class Armour {

    public BufferedImage image, image1, image2, image3;
    public int x, y;
    public int dir, material, article;

    public Armour(Armor a, World w) {

        image = a.image;
        
        dir = a.dir;
        material = a.material;
        article = a.article;

        spawn(w);

    }

    public void spawn(World w) {

        Random r = new Random();
        Tiles t = Tiles.STONE;
        while (t.solid) {
            x = r.nextInt(w.length * 2) % w.length;
            y = r.nextInt(w.width * 2) % w.width;
            t = w.getBlock(x, y);
        }
        x = Player.x;
        y = Player.y;
            w.armor.add(this);
    }

}

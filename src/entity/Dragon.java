/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import data.Entities;
import java.awt.image.BufferedImage;
import world.World;

/**
 *
 * @author Jacob
 */
public class Dragon extends Entity {

    public Dragon(Entities e, World w) {
        super(e, w);
        image = new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB);
        
        image.getGraphics().drawImage(Entities.DRAGON1.image, 0, 0, null);
        image.getGraphics().drawImage(Entities.DRAGON2.image, 64, 0, null);
        image.getGraphics().drawImage(Entities.DRAGON3.image, 0, 64, null);
        image.getGraphics().drawImage(Entities.DRAGON4.image, 64, 64, null);
    }

}

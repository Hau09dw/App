/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author A715-42G
 */
public class Imagebutton extends JButton {
    public Imagebutton(String image,int w, int h){
        
        //URL imageurl = getClass().getResource("../Resources/"+image);
        //ImageIcon a = new ImageIcon(imageurl);
        ImageIcon a = createreziedimage("../App/src/Resources/"+image, w, h);
        setIcon(a);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }
    private static ImageIcon createreziedimage(String path, int weight, int height){
        try{
            BufferedImage originalImange = ImageIO.read(new File(path));
            Image resizedImage = originalImange.getScaledInstance(weight, height, Image.SCALE_SMOOTH);
            
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

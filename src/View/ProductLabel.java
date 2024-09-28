/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author A715-42G
 */
public class ProductLabel extends JLabel{
    public ProductLabel(String text,Color color,int size){
        this.setText(text);
        this.setForeground(color);
        this.setFont(new Font("Arial",Font.BOLD,size));
    }
}

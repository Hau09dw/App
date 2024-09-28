/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
/**
 *
 * @author A715-42G
 */
public class UserPanel extends JPanel{
    public UserPanel(Color color, int w, int h){
        this.setBackground(color);
        this.setPreferredSize(new Dimension(w,h));  
    }
}
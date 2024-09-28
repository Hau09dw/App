/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author A715-42G
 */
public class GradientPanel extends JPanel {
   // private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Tạo đối tượng GradientPaint
        GradientPaint gradient = new GradientPaint(0, 0, Color.cyan, getWidth(), 0, Color.magenta);

        // Vẽ gradient trên nền của JPanel
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

}

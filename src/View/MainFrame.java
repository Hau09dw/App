/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author A715-42G
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TranTrungHau_IceCreamShop");
        URL iconURL = getClass().getResource("../Resources/cake.png");
        if(iconURL!=null){
            this.setIconImage(new ImageIcon(iconURL).getImage());
        }
        this.setVisible(true);
        //this.setLayout(new FlowLayout());
        
    }
    
}

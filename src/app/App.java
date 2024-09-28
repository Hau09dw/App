/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;
import View.GradientPanel;
import View.MainFrame;
import View.ProductLabel;
import View.UserPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import View.Product;
import View.payment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
/**
 *
 * @author A715-42G
 */
public class App {
    public static payment order_items;
    public static Product menuproduct;
    public static JTabbedPane tabpane;
    public static void main(String[] args) {
        //set frame
        MainFrame mainframe = new MainFrame();
        GradientPanel header_panel = new GradientPanel();
        JPanel body_panel = new JPanel();
       
        //constructer header - content
        ProductLabel title_label = new ProductLabel("TRUNG HAU ICECREAM SHOP",Color.WHITE,50);
        //constructer body
        tabpane = new JTabbedPane();
        UserPanel paneltab1 = new UserPanel(Color.white,0,0);
        UserPanel paneltab2 = new UserPanel(Color.white,0,0);
        order_items = new payment();
        
         //set layout frame
        mainframe.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        mainframe.add(header_panel,constraints);
        constraints.gridy  = 1;
        constraints.weighty = 0.95   ;
        mainframe.add(body_panel,constraints);
        //header----------------------------------------------------------
        header_panel.setLayout(new BorderLayout());
        
        header_panel.add(title_label,BorderLayout.CENTER);
        title_label.setHorizontalAlignment(JLabel.CENTER);
        //body------------------------------------------------------------
        body_panel.setLayout(new GridBagLayout());
        tabpane.addTab("ICE CREAM", paneltab1);
        tabpane.addTab("DRINK", paneltab2);
        UserPanel menupanel_product = new UserPanel(Color.white,0, 800);
        UserPanel menupanel_drink = new UserPanel(Color.white,0, 800);
        //JPanel menupanel =new JPanel();
        JScrollPane pane = new JScrollPane(menupanel_product,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane pane1 = new JScrollPane(menupanel_drink,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        paneltab1.setLayout(new BorderLayout(10,10));
        paneltab1.add(pane,BorderLayout.CENTER);
        paneltab2.setLayout(new BorderLayout(10,10));
        paneltab2.add(pane1,BorderLayout.CENTER);
        //set layout body
        GridBagConstraints constrains1 = new GridBagConstraints();
        constrains1.fill = GridBagConstraints.BOTH;
        constrains1.gridx = 0;
        constrains1.gridy = 0;
        constrains1.weightx = 0.7;
        constrains1.weighty = 1;
        body_panel.add(tabpane,constrains1);
        constrains1.gridx = 1;
        constrains1.weightx = 0.3;
        body_panel.add(order_items,constrains1);

       //Create object containt product menu
        ArrayList< Object[]> productlst = new ArrayList<>();
        Object[][] product_containers = 
                    {{"Mochi.jpg", "Mochi cream", 50},
                     {"Kulfi.jpg", "Kulfi cream", 20},
                     {"Helado.jpg", "Helado cream", 30},
                     {"Bia_Tiger.png", "Biger cream", 30},
                     {"Ais_Kacang.jpg", "Kacang cream", 10},
                     {"Croffle.jpg", "Croffle cream", 60},
                     {"Lus cream.jpg", "Lus cream", 20},
                     {"torte.jpg", "torte cream", 100},
                     {"gelato.jpg", "gelato cream", 40}
                    };
        for(Object[] product_container: product_containers){
            productlst.add(product_container);
        }
        for(int i=0;i<productlst.size();i++){
            Object[] element = productlst.get(i);
            int price = (int)element[2];
            menuproduct = new Product(element[0]+"",element[1]+"",price,1);
            menupanel_product.add(menuproduct);
        }
        //Create object containt product menu
        ArrayList< Object[]> drinklst = new ArrayList<>();
        Object[][] drinks_containers = 
                    {{"Smoothies_drink.jpg", "Smoothies", 20},
                     {"Bia_drink.jpg", "Bia", 10},
                     {"americano_drink.jpg", "America", 30},
                     {"cacao_drink.jpg", "Cacao", 30},
                     {"latte_drink.jpg", "Latte", 10},
                     {"Peachorangelemongrasstea_drink.jpg", "Peach orange lemon tea", 15},
                     {"matcha_drink.jpg", "Matcha", 20},
                     {"Fruittea_drink.jpg", "Fruite ted", 10},
                     {"Smoothies_drink.jpg", "Smoothies", 10}
                    };
        for(Object[] drinks_container: drinks_containers){
            drinklst.add(drinks_container);
        }
        for(int i=0;i<drinklst.size();i++){
            Object[] element = drinklst.get(i);
            int price = (int)element[2];
            menuproduct = new Product(element[0]+"",element[1]+"",price,1);
            menupanel_drink.add(menuproduct);
        }
    }
    
}

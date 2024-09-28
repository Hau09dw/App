/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import app.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author A715-42G
 */
public class payment extends JPanel{

    UserPanel panel;
    UserPanel panel1;
    UserPanel productorder_panel;
    UserPanel panel_up,panel_down;
    JTextField tftotal;
    ArrayList<Object[]> productorder_container;
    File file;
    public payment(){
        setLayout(new GridBagLayout());
        productorder_container = new ArrayList<>();
        //create panel-scrollpane
        
        panel = new UserPanel(Color.white, 0, 0);
        panel1 = new UserPanel(Color.white, 0, 0);
        productorder_panel = new UserPanel(Color.white, 0, 5000);
        JScrollPane scorllpane = new JScrollPane(productorder_panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        panel.setLayout(new BorderLayout(10,10));
        panel.add(scorllpane,BorderLayout.CENTER);
        //create total
        ProductLabel total_label = new ProductLabel("TOTAL", Color.black, 20);
        total_label.setHorizontalAlignment(JLabel.RIGHT);
        tftotal = new JTextField();
        tftotal.setFont(new Font("Arial",Font.BOLD,17));
        tftotal.setEditable(false);
        //set layout
        GridBagConstraints constraints =  new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.7;
        add(panel,constraints);
        constraints.gridy = 1;
        constraints.weighty = 0.3;
        add(panel1,constraints);
        //create panel up, down in panel_1  
        panel_up = new UserPanel(Color.white, 0, 0);
        panel_down = new UserPanel(Color.white, 0, 0);
        panel1.setLayout((new GridLayout(2,0)));
        panel1.add(panel_up);
        panel1.add(panel_down);
        // create button
        ProductLabel lbl1 = new ProductLabel("COFIRM", Color.white, 22);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        ProductLabel lbl2 = new ProductLabel("CLEAR", Color.white, 22);
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        JButton b1 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Tạo đối tượng GradientPaint
                GradientPaint gradient = new GradientPaint(0, 0, Color.cyan, getWidth(), getHeight(), Color.magenta);
                // Vẽ gradient trên nền của JPanel
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }};
        b1.setLayout(new BorderLayout());
        b1.add(lbl1,BorderLayout.CENTER);
        JButton b2 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Tạo đối tượng GradientPaint
                GradientPaint gradient = new GradientPaint(0, 0, Color.cyan, getWidth(), getHeight(), Color.magenta);
                // Vẽ gradient trên nền của JPanel
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }};
        b2.setLayout(new BorderLayout());
        b2.add(lbl2,BorderLayout.CENTER);
        //set action button confirm,clear
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                float total = 0;
                file = new File("B:\\bill.txt");
                try {  
                    PrintWriter writer = new PrintWriter(file);
                    if(file.exists()) 
                        file.createNewFile();
                    writer.println("Product \t| Price | Quality ");
                    for(Object[] arr_items: App.order_items.productorder_container){
                        String nameproduct = (String)arr_items[1];
                        int price = (int)arr_items[2];
                        int quality_product = (int)arr_items[3];
                        writer.println(nameproduct+"\t| $ "+price+"\t| "+quality_product);
                        total =  total + (float)price*quality_product;
                    }
                    writer.print("Total: $ "+total);
                    writer.close();
                }  catch (IOException ex) {
                    ex.printStackTrace();
                }
                finally{
                    tftotal.setText("$ "+total);
                }
                //show notify
                Scanner sc = null;
                String temp;
                
                try{
                    sc = new Scanner(file);
                    temp="";
                    while(sc.hasNext()){
                        String a = sc.nextLine();
                        System.out.print(a);
                        temp += a + System.lineSeparator();
                    }
                    int option = JOptionPane.showConfirmDialog(App.tabpane,
                    "Bill create!!\nDo you want to open Bill?", "Payment successfull!!",
                    JOptionPane.YES_NO_OPTION);
                    //URL iconURL = getClass().getResource("../Resources/cake.png");
                    ImageIcon customIcon = new ImageIcon();
                    if(option == JOptionPane.YES_OPTION){
                        int o = JOptionPane.showConfirmDialog(App.tabpane,
                        temp, "Bill",
                        JOptionPane.PLAIN_MESSAGE,
                                HEIGHT, customIcon);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                sc.close();
            }
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                App.order_items.productorder_container.clear();
                App.order_items.productorder_panel.removeAll();
                App.order_items.productorder_panel.updateUI();
                tftotal.setText("");
            }
        });
        // add button to panel_up
        panel_up.setLayout(new GridLayout(0,2,15,0));
        panel_up.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));
        panel_up.add(b1);
        panel_up.add(b2);
        // add total to panel_down
        
        panel_down.setLayout(new GridLayout(0,2,15,0));
        panel_down.setBorder(BorderFactory.createEmptyBorder(30,15,30,30));
        panel_down.add(total_label);
        panel_down.add(tftotal);
        
    }
} 

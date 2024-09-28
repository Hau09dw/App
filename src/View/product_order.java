/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import app.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author A715-42G
 */
public class product_order extends JPanel {
        //private Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        private Imagebutton b1,b2;
        static UserPanel panelframe,panelsub;
        private JTextField quality;
    public product_order(String image,int price){
        setBackground(Color.white);
        //setBorder(lineBorder);
        //constructer
        Imagebutton imgbtn = new Imagebutton(image, 250, 160);
        imgbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(product_order.this,
                    "Do you want to remove?", "Confirm Remove",
                    JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    for(int i = 0;i<App.order_items.productorder_container.size();i++){
                        Object[] arr = App.order_items.productorder_container.get(i);
                        if(Arrays.asList(arr).contains(image)){
                            App.order_items.productorder_container.remove(i);
                            App.order_items.productorder_panel.remove(product_order.this);
                            App.order_items.productorder_panel.updateUI();
                            break;
                        }
                    }
                }
            }
        });
        panelframe = new UserPanel(Color.white, 110, 110);
        panelsub = new UserPanel(Color.white, 100, 100);
        b1 = new Imagebutton("down.png", 34, 34);
        b2 = new Imagebutton("up.png", 34, 34);
        b1.setBorderPainted(true);
        b2.setBorderPainted(true);
        quality = new JTextField();
        for(Object[] arr_items: App.order_items.productorder_container){
                    String element_arr_items = (String)arr_items[0];
                    if(image.equals(element_arr_items)){
                        quality.setText(arr_items[3]+"");
                        break;
                    }
                }
        quality.setHorizontalAlignment(JTextField.CENTER);
        JTextField txtprice = new JTextField("$ "+price);
        txtprice.setFont(new Font("Arial",Font.BOLD,17));
        quality.setEditable(false);
        txtprice.setEditable(false);
        //set action up,down button
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object[] arr_items: App.order_items.productorder_container){
                    String element_arr_items = (String)arr_items[0];
                    if(image.equals(element_arr_items)){
                        int temp = (int)arr_items[3] - 1;
                        if(temp > 0){
                            arr_items[3] = temp;
                            quality.setText(arr_items[3]+"");
                            break;
                        } else break;
                        
                    }
                }
                product_order.panelsub.updateUI();
                App.order_items.productorder_panel.updateUI();     
            }
            
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object[] arr_items: App.order_items.productorder_container){
                    String element_arr_items = (String)arr_items[0];
                    if(image.equals(element_arr_items)){
                        arr_items[3] = (int)arr_items[3] + 1;
                        quality.setText(arr_items[3]+"");
                        break;
                    }
                }
                product_order.panelsub.updateUI();
                App.order_items.productorder_panel.updateUI();     
            }
           
        });
        //thanh tang quality product
        panelsub.setLayout(new GridLayout(0,3));
        panelsub.add(b1);
        panelsub.add(quality);
        panelsub.add(b2);
        //set layout leftpanel--> in productorder(product panel list)
        panelframe.setBorder(BorderFactory.createEmptyBorder(35,0,35,0));
        panelframe.setLayout(new GridLayout(2,0,0,30));
        panelframe.add(panelsub);
        panelframe.add(txtprice);
        
        //set layout -> primary panel(productorder)
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.6;
        constraints.weighty = 1;
        add(imgbtn,constraints);
        constraints.gridx = 1;
        constraints.weightx = 0.4;
        JPanel p1 = new JPanel();
        add(panelframe,constraints);
    }
    
}

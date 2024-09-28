/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import app.App;

/**
 *
 * @author A715-42G
 */
public class Product extends JPanel{
//    private Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
    Imagebutton imgbtn;
    ProductLabel lbl;
    ProductLabel lblprice;
    public static product_order productorder;
    public Product(String image,String text, int price,int quality){
//        setBorder(lineBorder);
        //set quality
        setBackground(Color.white);
        setLayout(new GridBagLayout());
        imgbtn = new Imagebutton(image,280,200);
        //action button--> add to prodcut_order_list
        imgbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object[] arr = {image,text,price,quality};
                String element_arr = (String)arr[0];
                boolean exists = false;
                for(Object[] arr_items: App.order_items.productorder_container){
                    String element_arr_items = (String)arr_items[0];
                    if(element_arr.equals(element_arr_items)){
                        exists = true;
                        break;
                    }
                }
               if (!exists)
                    App.order_items.productorder_container.add(arr);
                processArrays(App.order_items.productorder_container);
            }

            private void processArrays(ArrayList<Object[]> arrayList) {
                App.order_items.productorder_panel.removeAll();
                for (int i = 0; i < arrayList.size(); i++) {
                    Object[] element = arrayList.get(i);
                    int price = (int)element[2];
                    productorder = new product_order(element[0]+"",price);
                    App.order_items.productorder_panel.add(productorder);
                }           
                App.order_items.productorder_panel.updateUI();
            }
        });
        
        lbl = new ProductLabel("   "+text, Color.black, 20);
        lblprice = new ProductLabel("    $ " + price, Color.black, 15);
        //set layout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.8;
        add(imgbtn,constraints);
        constraints.gridy = 1;
        constraints.weighty = 0.1;
        add(lbl,constraints);
        constraints.gridy = 2;
        constraints.weighty = 0.1;
        add(lblprice,constraints);
        
    }

}

   

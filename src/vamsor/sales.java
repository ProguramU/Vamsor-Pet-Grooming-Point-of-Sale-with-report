/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamsor;

import com.sun.java.swing.plaf.motif.MotifBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*; //database
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Prog
 */
public class sales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImageIO.setUseCache(false);
                
        JPanel pnl_main = new JPanel();
        pnl_main.setLayout(new BoxLayout(pnl_main, BoxLayout.PAGE_AXIS));
        
        JLabel lbl_title = new JLabel("Vamsor Pet Grooming ");
        lbl_title.setHorizontalAlignment(JLabel.CENTER);
       
        JPanel pnl_search = new JPanel();
        pnl_search.setLayout(new BoxLayout(pnl_search, BoxLayout.LINE_AXIS));
        JTextField txtF_search = new JTextField();
        JButton btn_search = new JButton("Search");
        
        pnl_search.add(txtF_search);
        pnl_search.add(btn_search);
        
        JPanel pnl_products = new JPanel(new GridLayout(15, 1));

        
        

        //query get the number of products
        //query store it in array
        
        ArrayList<String> items = new ArrayList<>();
        
        for(int x = 0; x < 32; x++){
            //one item
            JPanel pnl_item = new JPanel();
            pnl_item.setLayout(new BoxLayout(pnl_item, BoxLayout.PAGE_AXIS));
            //image
            JButton btn_item = new JButton();
            try {
                BufferedImage picture = ImageIO.read(new File("src\\vamsor\\images\\sample.jpg"));
                btn_item = new JButton(new ImageIcon(picture.getScaledInstance(200, 200, Image.SCALE_FAST)));
                btn_item.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                    System.out.println("button item pressed");
                } 
            } );
                System.out.println("setting picture to Jlabel");
            } catch (Exception e) {
                System.out.println(e);
            }
            JLabel product_name = new JLabel("name");
            JLabel product_price = new JLabel("price");
            JLabel product_description = new JLabel("description");

            pnl_item.add(btn_item);
            pnl_item.add(product_name);
            pnl_item.add(product_price);
            pnl_item.add(product_description);
            //end of item

            pnl_products.add(pnl_item); 
        }
        
        JScrollPane scrlpn_products = new JScrollPane(pnl_products);

        
        JPanel pnl_transaction = new JPanel();
        pnl_transaction.setLayout(new BoxLayout(pnl_transaction, BoxLayout.LINE_AXIS));
        JButton btn_purchase = new JButton("Purchase");
        //button pressed
        btn_purchase.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("button purchase pressed");
            } 
        } );
        JButton btn_clear = new JButton("clear");
        btn_clear.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("button clear pressed");
            } 
        } );
        JButton btn_back = new JButton("Back");
        btn_back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("button back pressed");
                new EmployeeMenu().setVisible(true);
                
            } 
        } );
        
        
        pnl_transaction.add(btn_purchase);
        pnl_transaction.add(btn_back);
        pnl_transaction.add(btn_clear);
        
        pnl_main.add(lbl_title);
        pnl_main.add(pnl_search);
        pnl_main.add(scrlpn_products);
        pnl_main.add(pnl_transaction);
        
        JFrame salesFrame = new JFrame();
        //add components
        salesFrame.add(pnl_main);
        salesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salesFrame.pack();
        salesFrame.setLocationRelativeTo(null);
        salesFrame.setVisible(true);
        salesFrame.setSize(800,600);
        salesFrame.setResizable(false);
        
        
    }
    
}

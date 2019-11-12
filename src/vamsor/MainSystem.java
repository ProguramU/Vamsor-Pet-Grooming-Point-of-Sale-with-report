/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vamsor;
import java.sql.*; //database
import java.util.ArrayList;

/**
 *
 * @author Prog
 */
public class MainSystem {

    /**
     * @param args the command line arguments
     */
    
    ArrayList columnNames = new ArrayList();
    ArrayList data = new ArrayList();

    //  Connect to an MySQL Database, run query, get result set
    public static String getSQLurl(){
        return "jdbc:mysql://localhost:3306/vamsor";
    }
    
    public static String userid(){
        return "root";
    }
    
    public static String password(){
        return "";
    }

    
    
    
    public static void main(String[] args) {
        new LogInForm().setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.PokerTools.GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.io.IOException;

/**
 *
 * @author quent
 */
public class Fenetre extends JFrame {
    
   
    
    public Fenetre(String title) throws IOException{

        this.setSize(900, 700);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //Permet le resize des panels. 
        this.getContentPane().setLayout(new BorderLayout());  
        this.setVisible(true);
        
    }
    


    
}

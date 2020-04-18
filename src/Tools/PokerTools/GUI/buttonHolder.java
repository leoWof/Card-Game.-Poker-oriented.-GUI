/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.PokerTools.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author quent
 */
public class buttonHolder extends JPanel {
    
    
    public buttonHolder()
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 15));
        javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.BLACK,5);
        this.setBorder(blackline);
        
        this.setMaximumSize(new Dimension(800, 70));
        this.setBackground(Color.GREEN);
        
     
        this.setVisible(true);
   
        
    }
 
  }
    


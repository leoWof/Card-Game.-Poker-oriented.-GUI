/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.PokerTools.GUI;

import Tools.PokerTools.Gestion.PokerRounds;
import Tools.PokerTools.Player.Poker_player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author quent
 */
public class MainLayout extends JPanel {
    

    public ImageIcon[] Images;
     
    
    private static int index = 0; 
    
    
    public MainLayout(Poker_player player)
    {

        Images = player.getHand().getHandImages(); 
        player.getHand().dislayHand();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        
        JLabel playerID = new JLabel("Player " + player.getId());
        playerID.setFont (playerID.getFont ().deriveFont (30.0f));
        playerID.setAlignmentX(CENTER_ALIGNMENT);
        add(playerID);
        
        
        StakeAndToken moneyInfo = new StakeAndToken(player.getToken(), PokerRounds.getMinimumCave());
        moneyInfo.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(moneyInfo);
        
        

    }
    
    

    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("Cards_img/poker_carpet.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        
        int x = 100; 
        
        for(ImageIcon image:Images)
        {
            g.drawImage(image.getImage(), x, 400, 100, 170, null);
            x+=150;
        }
        
    
    }
    
    
    
    
}

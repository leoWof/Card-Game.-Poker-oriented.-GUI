/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.PokerTools.GUI;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author quent
 */
public class StakeAndToken extends JPanel {
    
    public StakeAndToken(int playerMoney, int stake)
    {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBackground(Color.RED);
        
        JLabel playerToken = new JLabel("Current money:"+playerMoney+"$", SwingConstants.CENTER);
        playerToken.setFont (playerToken.getFont ().deriveFont (30.0f));
        playerToken.setForeground(Color.WHITE);
        
        
        JLabel minimumStake = new JLabel("Minimum Stake:"+stake+"$   |   ", SwingConstants.CENTER);
        minimumStake.setFont (minimumStake.getFont ().deriveFont (30.0f));
        minimumStake.setForeground(Color.WHITE);
        add(minimumStake);
        add(playerToken);
    }
    
     
    
}

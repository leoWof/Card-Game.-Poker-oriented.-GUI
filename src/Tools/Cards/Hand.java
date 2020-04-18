 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.Cards;

import Tools.Cards.DeckOfCards;
import Tools.Cards.Card;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author quent
 */
public class Hand {
    
    protected Card[] hand; 
        
    
    public Hand(DeckOfCards deck, int length)
    {
        hand = new Card[length]; 
        for (int i = 0; i <5; i++) {
            this.hand[i] = deck.deal_card();

        }
    }
    
    /**
     * Display the hand in prompt
     */
    public void dislayHand()
    {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    
    /**
     * Return all the images of the hand. 
     * @return an array of ImageIcon[]
     */
    public ImageIcon[] getHandImages()
    {
        ImageIcon[] handImg = new ImageIcon[hand.length]; 
        String face, suit; 
        int index = 0; 
        for (Card card : hand) {
            face = card.getFace(); 
            suit = Character.toString(card.getSuit().charAt(0)); 
            handImg[index] = new ImageIcon("Cards_img/"+face+suit+".png");
            index++;
        }
        
        return handImg;
    }
    
    
    
    
    
}

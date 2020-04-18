/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGames;

import Tools.PokerTools.Gestion.PokerRounds;
import Tools.PokerTools.Player.Poker_player;
import Tools.Cards.Poker_hand;
import Tools.Cards.DeckOfCards;
import Tools.PokerTools.GUI.Fenetre;
import Tools.PokerTools.GUI.MainLayout;
import Tools.PokerTools.GUI.buttonHolder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author quent
 */
public class Poker {

    private static Poker_player players[];
    private static DeckOfCards deck;
    private static MainLayout[] layouts;
    private static boolean gameOver = false;

    private static JButton RaiseButton, FollowButton, FoldButton;
    private static int index = 0;
    private static Fenetre window;
    private static MainLayout layout;
    private static JComboBox raiseOption = new JComboBox();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Creation of the deck
        deck = new DeckOfCards();
        //Shuffle
        deck.shuffle();
        //Creation of a set of player
        players = init_player(3, deck);

        //Creation de la fenetre
        window = new Fenetre("Poker Game!");
        layout = new MainLayout(players[index]);

        buttonHolder buttonHolder = new buttonHolder();

        ////////////////////////////////
        ///Raise section          /////
        //////////////////////////////
        RaiseButton = new JButton("Raise");
        RaiseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players[index].raise(getRaiseOption());
                updateLayout();

            }
        });
        RaiseButton.setMargin(new Insets(10, 10, 11, 10));
        buttonHolder.add(RaiseButton);
        raiseOption.setPreferredSize(new Dimension(100, 20));
        setRaiseOptions();

        buttonHolder.add(raiseOption);

        ////////////////////////////////
        ///Follow section          /////
        //////////////////////////////
        FollowButton = new JButton("Follow");
        FollowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players[index].follow();
                updateLayout();

            }
        });
        FollowButton.setMargin(new Insets(10, 40, 11, 40));
        buttonHolder.add(FollowButton);

        ////////////////////////////////
        ///Fold section          /////
        //////////////////////////////
        FoldButton = new JButton("Fold");
        FoldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                players[index].fold();
                updateLayout();
                System.out.println(players.length);

            }
        });
        FoldButton.setMargin(new Insets(10, 40, 11, 40));
        buttonHolder.add(FoldButton);

        ////////////////////////////////
        ///Add composant to main window/////
        //////////////////////////////
        window.add(buttonHolder, BorderLayout.SOUTH);
        window.add(layout);
        window.setVisible(true);

        while (!gameOver) {

            if (players.length < 2) {
                System.out.println("Only one player left. \nEnd of the game.");
                System.out.println("Player " + players[0].getPlayerId() + "finish the game with " + players[0].getToken() + "$");
                gameOver = true;
            }

        }

    }

    public static Poker_player[] init_player(int x, DeckOfCards deck) {
        Poker_player players[] = new Poker_player[x];
        for (int i = 0; i < x; i++) {
            players[i] = new Poker_player(i + 1, new Poker_hand(deck, 5));
        }

        return players;
    }

    public static Poker_player[] setRemainingPlayers() {
        List<Poker_player> remainingPlayersList = new ArrayList<>();

        for (Poker_player player : players) {
            if (player.getState()) {
                remainingPlayersList.add(player);
            }
        }

        Poker_player[] remainingPlayer = new Poker_player[remainingPlayersList.size()];
        for (int i = 0; i < remainingPlayer.length; i++) {
            remainingPlayer[i] = remainingPlayersList.get(i);
        }

        return remainingPlayer;
    }

    public static void updateLayout() {
        System.out.println("INDEX ----------------> " + index);
        if (index == players.length - 1) {

            PokerRounds.finishRound(players);
            for (Poker_player player : players) {
                player.setNewHand(deck);
                player.resetRightToContinue();
            }

            index = 0;

        } else {
            index++;
        }
        setRaiseOptions();
        window.getContentPane().remove(layout);
        layout = new MainLayout(players[index]);
        window.getContentPane().add(layout);
        window.revalidate();
        window.repaint();
    }

    /**
     * Set the option of the combo box ruling the raise.
     */
    public static void setRaiseOptions() {
        raiseOption.removeAllItems();
        for (int i = PokerRounds.getMinimumCave() + 1; i <= players[index].getToken(); i++) {
            raiseOption.addItem(i + "$");
        }
    }

    public static int getRaiseOption() {
        String res = "";
        String value = raiseOption.getSelectedItem().toString();
        for (int index = 0; index < value.length() - 1; index++) {
            char to_add = value.charAt(index);
            res = res + "" + to_add;
        }
        return Integer.parseInt(res);
        //System.out.println("CardGames.Poker.getRaiseOption()---->" + result);

    }

}

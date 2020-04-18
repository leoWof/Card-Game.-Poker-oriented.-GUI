/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools.PokerTools.Player;

import Tools.Cards.DeckOfCards;
import Tools.Cards.Poker_hand;
import Tools.PokerTools.Gestion.PokerRounds;
import java.util.Scanner;

/**
 *
 * @author quent
 */
public class Poker_player {

    private int id;
    private Poker_hand pkr_hand;
    private int token;

    private boolean allowed_to_check = true;
    private boolean allowed_to_continue = true;
    private boolean playing = true;

    public Poker_player(int id, Poker_hand pk_h) {
        this.id = id;

        this.pkr_hand = pk_h;
        this.token = 150;
    }

    public Poker_hand getHand() {
        return this.pkr_hand;
    }

    public void setNewHand(DeckOfCards deck) {
        this.pkr_hand = new Poker_hand(deck, 5);
    }

    public int getPlayerId() {
        return this.id;
    }

    /**
     * Get an input. Check the validity of the input. Change the raise if the
     * input is Valid.
     */
    public void raise(int number) {


        this.token -= number;
        PokerRounds.setMinimumCave(number);
        PokerRounds.increaseTotalStake(number);

    }

    /**
     *
     */
    public void follow() {
        if (this.token >= PokerRounds.getMinimumCave()) {
            this.token -= PokerRounds.getMinimumCave();
            PokerRounds.increaseTotalStake(PokerRounds.getMinimumCave());
        }

    }

    public void fold() {
        this.allowed_to_continue = false;
    }

    public boolean getRightToContinue() {
        return this.allowed_to_continue;
    }
    
    public void resetRightToContinue()
    {
        this.allowed_to_continue = true;
    }
    

    public void check() {

    }

    public void describe_player_state() {
        System.out.println("\n\nPlayer: " + this.id + "  Money: " + this.token + "$  \nCURRENT MINIMUM BET ----> " + PokerRounds.getMinimumCave() + "$\n");
        getHand().dislayHand();
        getHand().checkHandPossibilities();
        getHand().displayTypeOfHand();

    }

    public int ChoseMove() {

        Scanner scanner = new Scanner(System.in);
        int[] possible_answer = {1, 2, 3, 4};
        int number = 0;

        System.out.println("\nChoose an option:\n1-Raise\n2-Follow\n3-Fold\n4-check");
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }

        number = scanner.nextInt();

        for (int elem : possible_answer) {
            if (number == elem) {
                return number;
            }

        }
        System.out.println(number + " is not a valid choice. Please enter a value between 1 & 4.");
        scanner.close();
        return ChoseMove();

    }

    
    public int getToken()
    {
        return this.token;
    }
    public void receiveMoney() {
        this.token += PokerRounds.getStake();
    }

    public void receiveMoneyEquality() {
        this.token += PokerRounds.getStake() / 2;
    }

    public int stopOrNot() {
        Scanner scanner = new Scanner(System.in);

        int number = 0;

        System.out.println("Player " + this.id + " do you wish to continue?\n (1) yes  /  2(no).");
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }

        number = scanner.nextInt();
        if (number == 2) {
            this.playing = false;

        } else if (number == 1) {
            return 0;

        } else if (number != 2 || number != 1) {
            System.out.println(number + " is not a valid choice. Please enter a value between 1 & 2.");
            scanner.close();
            return stopOrNot();
        }

        return 0;
    }

    public boolean getState() {
        return this.playing;
    }
    
    public int getId()
    {
        return this.id; 
    }

}
